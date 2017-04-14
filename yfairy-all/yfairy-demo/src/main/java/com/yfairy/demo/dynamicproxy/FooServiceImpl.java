package com.yfairy.demo.dynamicproxy;

public class FooServiceImpl implements FooService {

	@Override
	public String hello(String name) {
		System.out.println("hello," + name);
		return "hello" + name;
	}

}
