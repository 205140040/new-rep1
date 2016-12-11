package com.yfairy.demo.rmi.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloRmi extends Remote {
	void hello(String name) throws RemoteException;

	User showUser(User user) throws RemoteException;
}
