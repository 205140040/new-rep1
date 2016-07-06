package com.demo.deep.c18.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BiaoZhunIoDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 标准输入：输出，错误 system.in system.out system.err
		 */
		BufferedInputStream stdin = new BufferedInputStream(System.in);
		byte[] bs = new byte[stdin.available()];
		stdin.read(bs);// 读标准输入到 bs字节数组中
		System.out.println(new String(bs, "UTF-8"));
		stdin.close();
		// system.out是printstream
		/**
		 * 标准io重定向
		 * setIn(）
		 * setOut()
		 * setErr()
		 */
		System.setOut(new PrintStream(new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\tio2.txt"))));
		PrintStream printStream = new PrintStream(System.out);
		printStream.println("hello");
		printStream.close();
		
	}

}
