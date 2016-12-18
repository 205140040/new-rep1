package com.yfairy.demo.thinkinginjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			// 设置ip
			InetAddress localInetAddress = InetAddress.getLocalHost();
			// 建立socket网络连接
			socket = new Socket(localInetAddress, 8080);
			System.out.println("client　socket：" + socket);
			// 获取套接字输入输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			scanner = new Scanner(System.in);
			String line = null;
			while (!"end".equalsIgnoreCase(line)) {
				// 发送请求数据
				System.out.println("请输入请求内容:");
				line = scanner.nextLine();
				out.println(line);
				// 输出服务端响应的类容:
				String responseStr = reader.readLine();
				System.out.println("responseStr:" + responseStr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
