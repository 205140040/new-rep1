package com.yfairy.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FooServiceInvocationHandler implements InvocationHandler {
	/**
	 * 真实服务对象，即代理类调用的原始类
	 */
	private Object originalObject;

	public <T> T bind(Object originalObj) {
		this.originalObject = originalObj;
		// ClassLoader loader 真实服务类 的类加载器
		// Class<?>[] interfaces, 的接口
		// InvocationHandler h 代理处理器
		return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(),
				originalObject.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("----------------- jdk 动态代理 start -----------------");
		result = method.invoke(originalObject, args);
		System.out.println("----------------- jdk 动态代理 end -----------------");

		return result;
	}

}
