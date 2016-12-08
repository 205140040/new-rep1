package com.yfairy.demo.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {

		@Override
		public void sayHello() {
			System.out.println("hello,world");
		}

	}

	static class DynamicProxy implements InvocationHandler {

		Object origalObject;

		Object bind(Object obj) {
			this.origalObject = obj;
			return Proxy.newProxyInstance(origalObject.getClass().getClassLoader(),
					origalObject.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("welcome");
			return method.invoke(origalObject, args);
		}

	}

	public static void main(String[] args) {
		// 加入此属性，会在与src同目录下创建生成的代理类class
		// System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",
		// "true");
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
	}

}
