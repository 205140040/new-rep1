package com.yfairy.demo.thinkinginjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 提供多个socket请求的server
 * 
 * @author jiangzi
 *
 */
public class MultiServerSocket extends Thread {

	private Socket socket;

	public MultiServerSocket(Socket s) {
		super();
		// 初始化套接字
		socket = s;
		// 启动线程
		start();
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			String con = reader.readLine();
			System.out.println("[" + socket + "]" + "请求数据:" + con);
			out.println("服务端响应:" + con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		/**
		 * 服务多个客户<br>
		 * 最基本的方法是在服务器（程序）里创建单个 ServerSocket，<br>
		 * 并调用 accept()来等候一个新连接。一旦 accept()返回，我们就取得结果获得的 Socket，<br>
		 * 并用它新建一个线程，令其只为那个特定的客户服务。然后 再调用 accept()<br>
		 * ，等候下一次新的连接请求。<br>
		 */
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8080);
			while (true) {
				Socket s = serverSocket.accept();
				new MultiServerSocket(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
