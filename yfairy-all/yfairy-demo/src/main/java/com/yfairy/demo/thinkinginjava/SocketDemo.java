package com.yfairy.demo.thinkinginjava;

import java.net.InetAddress;

public class SocketDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * think in java<br>
		 * 第15章：网络编程538/688<br>
		 * 15.3服务多个客户543/688<br>
		 * 15.4数据报UDP 547/688 TODO 待继续学习<br>
		 */
		// 获取本机ip信息
		InetAddress localinetAddress = InetAddress.getLocalHost();
		System.out.println("localinetAddress:" + localinetAddress);
		System.out.println("getHostAddress:" + localinetAddress.getHostAddress());

		// 通过主机名称获得ip信息:getByName 如XXX-XXX
		// InetAddress inetAddress = InetAddress.getByName("XXX-XXX");
		// System.out.println("getByName:" + inetAddress);
		/**
		 * 端口编号在这里扮演了重要的角色，它 是必需的一种二级定址措施。<br>
		 * 也就是说，我们请求一个特定的端口，便相当于请求与那个端口编号关联的服 务。<br>
		 */
		// 在 Java 中，我们创建一个套接字，用它建立与其他机器的连接。从套接字得到的结果是一个 InputStream 以
		// 及 OutputStream（若使用恰当的转换器，则分别是 Reader 和 Writer），以便将连接作为一个 IO 流对象对
		// 待。
	}

}
