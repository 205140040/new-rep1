package com.yfairy.demo.javacore;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.util.StreamUtils;

public class NetDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 第3章：网络166/858<br>
		 */

		// 因特网地址
		InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
		System.out.println(inetAddress);

		// 获取所有的地址
		System.out.println("获取所有的地址");
		InetAddress[] alladdr = InetAddress.getAllByName("www.baidu.com");
		for (InetAddress addr : alladdr) {
			System.out.println(addr);
		}

		System.out.println("获取本机地址");
		InetAddress localAddr = InetAddress.getLocalHost();
		System.out.println(localAddr);

		// 创建连接
		try {
			Socket socket = new Socket(inetAddress, 80); // 设置超时
			socket.setSoTimeout(2000); // 2秒
			InputStream in = socket.getInputStream();
			byte[] datas = StreamUtils.copyToByteArray(in);
			System.out.println(new String(datas, "UTF-8"));
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 套接字服务器
		// 可运行telnet ip 8189 ,即可获取响应:hello
		ServerSocket serverSocket = new ServerSocket(8189);
		Socket inSocket = serverSocket.accept(); // 接受一个连接
		InputStream in = inSocket.getInputStream();

		OutputStream out = inSocket.getOutputStream();
		out.write(new String("hello").getBytes());
		out.write(new String("please in content").getBytes());
		Scanner scanner = new Scanner(in);
		String line = scanner.nextLine();
		while (!line.equals("end")) {
			String res = new String(new String("echo:" + line).getBytes(), "UTF-8");
			out.write(res.getBytes());
			line = scanner.nextLine();
		}
		scanner.close();
		inSocket.close();
		serverSocket.close();

		// URL对象，创建网络连接到web服务器
		// URL直接获取服务器响应，用于简单的web连接
		URL url = new URL("https://www.baidu.com");
		InputStream urlIn = url.openStream();
		byte[] urlDatas = StreamUtils.copyToByteArray(urlIn);
		System.out.println(new String(urlDatas, "UTF-8"));

		// URLConnection用于web连接，可添加请求信息，已经获取响应信息头等
		URLConnection urlConnection = url.openConnection();
		// 设置请求参数
		urlConnection.setRequestProperty("name", "hahah");
		Map<String, List<String>> resh = urlConnection.getHeaderFields();
		System.out.println("响应头:" + resh);
	}

}
