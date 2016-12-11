package com.yfairy.demo.rmi.server;

import java.rmi.RemoteException;

import com.yfairy.demo.rmi.rmiinterface.IHelloRmi;
import com.yfairy.demo.rmi.rmiinterface.User;

public class HelloRmiImpl implements IHelloRmi {

	@Override
	public void hello(String name) throws RemoteException {
		System.out.println("hello rmi ," + name);
	}

	@Override
	public User showUser(User user) throws RemoteException {
		System.out.println("服务端输出:" + user);
		return user;
	}

}
