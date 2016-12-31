package com.yfairy.demo.javacore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
	public static void main(String[] args) {
		/**
		 * 6.5动态代理263/720<br>
		 * 动态代理可以达到类似aop的效果.<br>
		 * 1. 什么是动态代理: (http://mt.sohu.com/20161115/n473206016.shtml)
		 * 代理类在程序运行时创建的代理方式被成为 动态代理。<br>
		 * 也就是说，这种情况下，代理类并不是在Java代码中定义的，<br>
		 * 而是在运行时根据我们在Java代码中的“指示”动态生成的。<br>
		 * 相比于静态代理，<br>
		 * 动态代理的优势在于可以很方便的对代理类的函数进行统一的处理，<br>
		 * 而不用修改每个代理类的函数。<br>
		 * 具体列子参考2：百度(http://wenku.baidu.com/link?url=XklbPfm3pnRHzyvjY6eTzg7UPkj8VEkuZD8V9WaOIGwsHe_LHyuZ0CigW_qhCX5qHY2UOv6zx3tjz-T_Iy2OKPvoSpxDzbSYWROdEi2wysa)
		 */

		/**
		 * 创建代理对象<br>
		 * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces,
		 * InvocationHandler h)<br>
		 * ClassLoader原始接口的ClassLoader，Class<?>[]
		 * interfaces,原始接口class数组,InvocationHandler实现该接口的代理处理器
		 */
		IHelloService originalObj = new HelloServiceImpl();
		InvocationHandler invocationHandler = new HelloInvocationHandler(originalObj);

		IHelloService proxyHelloService = (IHelloService) Proxy.newProxyInstance(IHelloService.class.getClassLoader(),
				new Class[] { IHelloService.class }, invocationHandler);
		proxyHelloService.sayHello("盖伦");
	}
}
