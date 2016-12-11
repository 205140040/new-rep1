package com.yfairy.demo.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.yfairy.demo.rmi.rmiinterface.IHelloRmi;
import com.yfairy.demo.rmi.rmiinterface.User;

public class RmiClientMain {

	public static void main(String[] args) {
		try {
			// Registry registry = LocateRegistry.getRegistry(args[0]);
			Registry registry = LocateRegistry.getRegistry("localhost", 2001);
			IHelloRmi helloRmi = (IHelloRmi) registry.lookup("HelloRmi");
			helloRmi.hello("李思思");
			User paramUser = new User();
			paramUser.setUsername("哈哈哈");
			paramUser.setAge(10);
			User clientUser = helloRmi.showUser(paramUser);
			System.out.println("客户端输出返回结果:" + clientUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
