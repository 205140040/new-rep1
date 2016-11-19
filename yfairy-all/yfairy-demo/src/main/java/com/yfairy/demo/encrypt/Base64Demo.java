package com.yfairy.demo.encrypt;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Demo {

	private static final String UTF_8 = "UTF-8";

	public static void main(String[] args) throws Exception {
		/**
		 * Base64是网络上最常见的用于传输8Bit字节代码的编码方式之一，<br>
		 * 大家可以查看RFC2045～RFC2049，上面有MIME的详细规范。<br>
		 * 采用Base64编码具有不可读性，即所编码的数据不会被人用肉眼所直接看到。<br>
		 * 这篇文章很好:http://www.importnew.com/14961.html<br>
		 * ,base64也可用于注册发邮件中的参数
		 */
		// apache中codec 中的base64编码，解码
		String enStr = apacheCodecBase64Encode("hahe86");
		System.out.println("enStr:" + enStr);
		String deStr = apacheCodecBase64Decode(enStr);
		System.out.println("deStr:" + deStr);
		// java8中java.util中的base64编码解码，效率高,
		// java.util.Base64.getUrlEncoder()
		// java.util.Base64.getMimeDecoder()
		// java.util.Base64.getEncoder()
		System.out.println("------------------------------");
		String jenstr = java8Base64Encode("hahe86");
		System.out.println("jenstr:" + jenstr);
		String jdestr = java8Base64Decode(jenstr);
		System.out.println("jdestr:" + jdestr);
	}

	public static String apacheCodecBase64Encode(String source) {
		Base64 base64 = new Base64();
		String res = null;
		try {
			System.out.println(base64.encode(source.getBytes(UTF_8)));
			res = new String(base64.encode(source.getBytes(UTF_8)), UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static String apacheCodecBase64Decode(String source) {
		Base64 base64 = new Base64();
		String res = null;
		try {
			res = new String(base64.decode(source.getBytes(UTF_8)), UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static String java8Base64Encode(String source) {
		try {
			return java.util.Base64.getEncoder().encodeToString(source.getBytes(UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String java8Base64Decode(String source) {
		try {
			byte[] bytes = java.util.Base64.getDecoder().decode(source.getBytes(UTF_8));
			String res = new String(bytes, UTF_8);
			return res;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
