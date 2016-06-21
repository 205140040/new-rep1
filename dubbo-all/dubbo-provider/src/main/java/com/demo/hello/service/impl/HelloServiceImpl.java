package com.demo.hello.service.impl;

import org.apache.log4j.Logger;

import com.demo.hello.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.hello.service.impl.IHelloService#sayHello(java.lang.String)
	 */
	private Logger logger = Logger.getLogger(HelloServiceImpl.class);

	@Override
	public void sayHello(String name) {
		logger.info("访问了:sayHello");
		System.out.println(name + ",hello");
	}
}
