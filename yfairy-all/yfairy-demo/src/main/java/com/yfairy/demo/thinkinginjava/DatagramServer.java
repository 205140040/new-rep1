package com.yfairy.demo.thinkinginjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {

	public static void main(String[] args) {

		try {
			// 创建服务端+端口
			DatagramSocket serverSocket = new DatagramSocket(8080);

			// 接收数据的byte
			byte[] container = new byte[4096];
			// 封装成包
			DatagramPacket serverPacket = new DatagramPacket(container, container.length);

			System.out.println("等待接收.....");
			// 4、接收数据
			serverSocket.receive(serverPacket);
			System.out.println("客户端发送的数据:" + new String(container));

			System.out.println(
					"发送端DatagramPacketAddress:" + serverPacket.getAddress() + "\t 发送端Port:" + serverPacket.getPort());

			// 服务端发送给客户
			String serverStr = "服务端响应:world";
			byte[] sdata = serverStr.getBytes();
			InetAddress inetAddress = InetAddress.getByName(serverPacket.getAddress().getHostName());
			DatagramPacket sendPacket = new DatagramPacket(sdata, sdata.length, inetAddress, serverPacket.getPort());
			serverSocket.send(sendPacket);

			// 关闭socket
			serverSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
