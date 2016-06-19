package com.demo.hello.service.impl;

import com.demo.hello.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
	/* (non-Javadoc)
	 * @see com.demo.hello.service.impl.IHelloService#sayHello(java.lang.String)
	 */
	@Override
	public void sayHello(String name) {
		System.out.println(name + ",hello");
	}
}
