package com.yfairy.demo.javacore;

public class HelloServiceImpl implements IHelloService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yfairy.demo.javacore.IHelloService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		String res = "hello," + name;
//		System.out.println("原始类运行:" + res);
		return res;
	}
}
