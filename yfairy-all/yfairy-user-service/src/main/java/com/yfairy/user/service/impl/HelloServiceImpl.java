package com.yfairy.user.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.yfairy.user.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
	@Value("${yfjdbc.url}")
	private String jurl;

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
