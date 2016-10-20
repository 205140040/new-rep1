package com.yfairy.common.utils;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {

	private static Logger logger = Logger.getLogger(HttpClientUtil.class);
	// 字符
	private final static String CHAR_SET = "UTF-8";

	// SOCKET_TIMEOUT
	private static final Integer SOCKET_TIMEOUT = 5000;
	// 连接超时时间
	private static final Integer CONNECT_TIMEOUT = 5000;
	// 连接池
	private static PoolingHttpClientConnectionManager cm;
	// HttpRequestRetryHandler
	private static HttpRequestRetryHandler myHttpRequestRetryHandler;
	// 请求配置
	private static RequestConfig requestConfig;

	/**
	 * 初始化httpClient连接池和requestConfig
	 */
	static {
		myHttpRequestRetryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (5 <= executionCount) {
					// 不要重试，如​​果超过最大重试次数
					logger.info("retryRequest:如​​果超过最大重试次数");
					return false;
				}
				if (exception instanceof InterruptedIOException) {
					// timeout
					logger.info("retryRequest:timeout");
					return false;
				}
				if (exception instanceof UnknownHostException) {
					// 未知主机
					logger.info("retryRequest:未知主机");
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {
					// 拒绝连接
					logger.info("retryRequest:拒绝连接");
					return false;
				}
				if (exception instanceof SSLException) {
					// SSL handshake exception
					logger.info("retryRequest:SSL handshake exception");
					return false;
				}
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// 重试，如果请求被认为是幂等
					logger.info("retryRequest:重试，如果请求被认为是幂等");
					return true;
				}
				return false;

			}
		};
		cm = new PoolingHttpClientConnectionManager();
		// Increase max total connection to 200
		cm.setMaxTotal(100);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		// Increase max connections for localhost:80 to 50
		HttpHost localhost = new HttpHost("locahost", 80);
		cm.setMaxPerRoute(new HttpRoute(localhost), 50);
		// 设置请求和传输超时时间
		requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
				.build();
	}

	public static CloseableHttpClient getHttpClient() {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm)
				.setRetryHandler(myHttpRequestRetryHandler).build();
		return httpClient;
	}

	public static String get(String url) {
		String res = null;
		URI uri = URI.create(url);
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpClient = getHttpClient();
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public static String post(String url) {
		String res = null;
		URI uri = URI.create(url);
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpClient = getHttpClient();
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public static String post(String url, List<NameValuePair> params) {
		String res = null;
		URI uri = URI.create(url);
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		if (NullUtil.isNotEmpty(params)) {
			UrlEncodedFormEntity formEntity = null;
			try {
				formEntity = new UrlEncodedFormEntity(params, CHAR_SET);
				httpPost.setEntity(formEntity);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpClient = getHttpClient();
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public static <T> String postBean(String url, T bean) {
		String res = null;
		URI uri = URI.create(url);
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		if (NullUtil.isNotEmpty(bean)) {
			JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(bean));
			List<NameValuePair> params = new ArrayList<>();
			for (Entry<String, Object> entry : jsonObject.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
			}
			UrlEncodedFormEntity formEntity = null;
			try {
				formEntity = new UrlEncodedFormEntity(params, CHAR_SET);
				httpPost.setEntity(formEntity);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpClient = getHttpClient();
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public static String postMultipartFile(String url, MultipartFile multipartFile) {
		String res = null;
		URI uri = URI.create(url);
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		if (NullUtil.isNotEmpty(multipartFile) && !multipartFile.isEmpty()) {
			HttpEntity httpEntity = null;
			try {
				ContentBody contentBody = new ByteArrayBody(multipartFile.getBytes(),
						multipartFile.getOriginalFilename());
				httpEntity = MultipartEntityBuilder.create().addPart("file", contentBody).build();
				httpPost.setEntity(httpEntity);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpClient = getHttpClient();
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(get("http://www.baidu.com"));
		System.out.println(get("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15000395588"));
		List<NameValuePair> ps = new ArrayList<>();
		ps.add(new BasicNameValuePair("tel", "15000395588"));
		System.out.println(post("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm", ps));
		System.out.println(post("http://localhost:8081/testHttpClient/test?name=zhangsan"));
	}

}
