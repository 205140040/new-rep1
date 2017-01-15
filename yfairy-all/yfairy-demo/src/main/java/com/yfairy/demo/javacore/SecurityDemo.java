package com.yfairy.demo.javacore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityDemo {

	static class MyClassLoader extends ClassLoader {

		public MyClassLoader() {
			super();
		}

		public MyClassLoader(ClassLoader parent) {
			super(parent);
		}

	}

	public static void main(String[] args) throws Exception {
		/**
		 * 第9章：安全659/858<br>
		 * 9.1类加载器<br>
		 */
		System.out.println(SecurityDemo.class.getClassLoader().getParent().getParent());
		System.out.println(SecurityDemo.class.getClassLoader().getParent());
		System.out.println(SecurityDemo.class.getClassLoader());

		// 设置上下文类加载器，通过此方式可以在类加载时设置父类加载器加载子类加载器中的类
		Thread thread = Thread.currentThread();
		ClassLoader pClassLoader = new MyClassLoader();
		ClassLoader myClassLoader = new MyClassLoader(pClassLoader);
		thread.setContextClassLoader(myClassLoader);
		// 获取上下文类加载器
		ClassLoader loader = thread.getContextClassLoader();
		System.out.println(loader);
		Class c = loader.loadClass("com.yfairy.demo.javacore.SecurityDemo");
		System.out.println("自定义类加载器:" + c.getClassLoader());

		// 9.2类校验，查看是否有局部变量未初始化，其他类中访问private字段，等
		// VerifyError 校验异常

		// 9.3安全管理器与访问权限672/858<br>

		// 9.5数字签名

		// MessageDigest.getInstance(md5OrSha);返回信息摘要对象

		// messageDigest.update(input); 使用字节更新摘要

		// messageDigest.digest();完成计算，返回计算所得的摘要，重置MessageDigest
		String pwd = "haha123.5";
		System.out.println("md5Hex:" + digestHex(pwd.getBytes(), "MD5"));
		System.out.println("shaHex:" + digestHex(pwd.getBytes(), "SHA-1"));
		System.out.println("shaHex:" + digestHex("haha1235".getBytes(), "SHA-1"));

		// 9.6代码签名

		// 9.7加密

	}

	public static String digestHex(byte[] input, String md5OrSha) throws NoSuchAlgorithmException {
		// MessageDigest.getInstance(md5OrSha);返回信息摘要对象
		// messageDigest.update(input); 使用字节更新摘要
		// messageDigest.digest();完成计算，返回计算所得的摘要，重置MessageDigest
		MessageDigest messageDigest = MessageDigest.getInstance(md5OrSha);
		messageDigest.update(input);
		byte[] mdresult = messageDigest.digest();
		// 128位转32位大写
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < mdresult.length; i++) {
			int v = mdresult[i] & 0xFF;
			if (v < 16) {
				res.append(0);
			} else {
				res.append(Integer.toString(v, 16).toUpperCase());
			}
		}
		return res.toString();
	}
}
