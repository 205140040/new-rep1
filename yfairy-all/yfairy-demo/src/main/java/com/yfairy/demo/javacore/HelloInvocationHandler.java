package com.yfairy.demo.javacore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocationHandler implements InvocationHandler {
	/**
	 * 动态代理原始对象
	 */
	private Object originalObj;

	public HelloInvocationHandler(Object originalObj) {
		super();
		this.originalObj = originalObj;
	}

	/**
	 * 动态代理处理器方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 运行前置方法
		doBefore();

		Object result = null;
		System.out.println("method:" + method);
		for (Object arg : args) {
			System.out.println("参数:" + arg);
		}

		System.out.println("-----------原始对象方法start-------------");
		result = method.invoke(originalObj, args); // 运行原始对象方法
		System.out.println("原始对象方法result:" + result);
		System.out.println("-----------原始对象方法end---------------");

		// 运行后置方法
		doAfter();

		return result;
	}

	private void doBefore() {
		System.out.println("前置方法doBefore...");
	}

	private void doAfter() {
		System.out.println("后置方法doAfter...");
	}
}
