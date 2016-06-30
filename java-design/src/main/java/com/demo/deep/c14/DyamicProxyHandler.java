package com.demo.deep.c14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 动态代理
 */
public class DyamicProxyHandler implements InvocationHandler{
	
	private Object proxy;
	

	public DyamicProxyHandler(Object proxy) {
		super();
		this.proxy = proxy;
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy:"+proxy.getClass()+",method:"+method.getName());
		return method.invoke(proxy, args);
	}

}
