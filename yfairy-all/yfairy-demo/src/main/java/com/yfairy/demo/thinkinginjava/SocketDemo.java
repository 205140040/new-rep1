package com.yfairy.demo.thinkinginjava;

import java.net.InetAddress;

public class SocketDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * think in java<br>
		 * 第15章：网络编程538/688<br>
		 * 15.3服务多个客户543/688<br>
		 * 15.4数据报UDP 547/688 <br>
		 * java中的socket即TCP,数据报：即UDP<br>
		 * 传输控制协议（ TCP）<br>
		 * 用户数据报协议（ UDP）<br>
		 * TCP 和 UDP 端口是相互独立的。也就是说，可以在端口 8080 同时运行一个 TCP 和 UDP 服务程 序<br>
		 * ，两者之间不会产生冲突。<br>
		 * 可参考:http://wiki.jikexueyuan.com/project/java-socket/(很好)<br>
		 * 可参考：http://m.codes51.com/article/detail_138617.html<br>
		 * 
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
