package com.yfairy.demo.thinkinginjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class MultiClientSocket extends Thread {

	private Socket socket;

	public MultiClientSocket(InetAddress address, Integer port) {
		try {
			socket = new Socket(address, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		start();
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
					true);
			out.println("请求" + new Date().toString());

			String res = reader.readLine();
			System.out.println("请求的[" + socket + "]" + "响应数据:" + res);

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

	public static void main(String[] args) throws Exception {
		InetAddress inetAddress = InetAddress.getLocalHost();
		for (int i = 0; i < 12; i++) {
			new MultiClientSocket(inetAddress, 8080);
			Thread.sleep(1500);
		}

	}

}
