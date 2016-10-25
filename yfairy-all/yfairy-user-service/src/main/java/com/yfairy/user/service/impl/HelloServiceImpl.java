package com.yfairy.user.service.impl;

import com.yfairy.user.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yfairy.user.service.IHelloService2#hello(java.lang.String)
	 */
	@Override
	public String hello(String name) {
		String res = "hello：" + name;
		System.out.println(res);
		return res;
	}
}
