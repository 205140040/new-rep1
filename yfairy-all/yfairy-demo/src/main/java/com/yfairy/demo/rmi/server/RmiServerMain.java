package com.yfairy.demo.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.yfairy.demo.rmi.rmiinterface.IHelloRmi;

public class RmiServerMain {
	public static void main(String[] args) {
		// 注释掉，不然安全连接失败
		// if (System.getSecurityManager() == null) {
		// System.setSecurityManager(new SecurityManager());
		// }
		try {
			IHelloRmi helloImpl = new HelloRmiImpl();
			IHelloRmi helloStub = (IHelloRmi) UnicastRemoteObject.exportObject(helloImpl, 0);
			// Bind the remote object's stub in the registry
			// Registry registry = LocateRegistry.getRegistry(); 此处注释掉，指定端口时才可使用
			Registry registry = LocateRegistry.createRegistry(2001);
			registry.rebind("HelloRmi", helloStub);
			System.out.println("server is ready");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
