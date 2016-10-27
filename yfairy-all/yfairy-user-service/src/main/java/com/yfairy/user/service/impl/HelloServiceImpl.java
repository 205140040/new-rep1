package com.yfairy.user.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yfairy.user.service.IHelloService;

@Service(value="HelloServiceImpl")
public class HelloServiceImpl implements IHelloService {
	@Value("${jdbc.url}")
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
		System.out.println(jurl);
		return res;
	}
}
