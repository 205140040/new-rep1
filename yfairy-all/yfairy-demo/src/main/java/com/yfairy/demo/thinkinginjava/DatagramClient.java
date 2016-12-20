package com.yfairy.demo.thinkinginjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {

	public static void main(String[] args) {
		/**
		 * 可参考:http://wiki.jikexueyuan.com/project/java-socket/udp.html<br>
		 * UDP使用: DatagramPacket数据包用于设置数据，对方ip，端口,DatagramSocket用于发送，或接收数据
		 */
		try {
			String sendStr = "hello";
			InetAddress inetAddress = InetAddress.getByName("localhost");
			// 建立udpsocket
			DatagramSocket datagramSocket = new DatagramSocket();
			// 创建包含 发送data,目标ip，port的的DatagramPacket数据包
			byte[] data = sendStr.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, 8080);
			// 发送
			datagramSocket.send(datagramPacket);

			// 接收服务端响应
			byte[] tempData = new byte[4096];
			DatagramPacket resPacket = new DatagramPacket(tempData, tempData.length);
			datagramSocket.receive(resPacket);
			// DatagramPacket.getData 也可以获取数据包内容bytes
			System.out.println("服务端响应类容:" + new String(resPacket.getData()));

			datagramSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
