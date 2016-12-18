package com.yfairy.demo.thinkinginjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 套接字服务类，用于在指定的端口，提供套接字server服务
 * 
 * @author jiangzi
 *
 */
public class MyServerSocket {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Scanner scanner = null;
		try {
			// 建立一个套接字Server，用于接收客户端Socket
			serverSocket = new ServerSocket(8080);
			System.out.println("started" + serverSocket);
			Socket socket = serverSocket.accept(); // 接收客户端套接字
			// 获取网络连接socket中的输入，输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 设置true，使每次调用println时立即刷新输出，若刷新没有发生，那么信息不会进
			// 入网络，除非缓冲区满（溢出）
			PrintWriter printWriter = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			scanner = new Scanner(System.in);
			while (true) {
				String content = reader.readLine();
				if ("END".equalsIgnoreCase(content)) {
					break;
				}
				System.out.println("客户端网络请求的数据:" + content);
				System.out.println("请输出响应内容:");
				String responseStr = scanner.nextLine();
				printWriter.println("服务的响应:" + responseStr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != scanner) {
				scanner.close();
			}
			try {
				if (null != serverSocket) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
