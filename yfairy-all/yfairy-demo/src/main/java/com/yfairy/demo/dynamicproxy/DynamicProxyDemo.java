package com.yfairy.demo.dynamicproxy;

public class DynamicProxyDemo {

	public static void main(String[] args) {
		/**
		 * JDK动态代理
		 */
		FooServiceInvocationHandler fooServiceProxy = new FooServiceInvocationHandler();
		FooService fooServiceDynamicProxy = fooServiceProxy.bind(new FooServiceImpl());
		fooServiceDynamicProxy.hello("李思思");

		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();

		/**
		 * cglib动态代理
		 */
		CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
		FooService cglibFooProxy = (FooService) cglibDynamicProxy.bind(new FooServiceImpl());
		System.out.println();
		String reString = cglibFooProxy.hello("露露");
		System.out.println("方法结果:" + reString);
	}

}
