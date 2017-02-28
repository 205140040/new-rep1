package com.yfairy.demo.spring_in_action_2;

public class HelloServiceImpl implements IHelloService {

	private String name;

	public HelloServiceImpl() {
		super();
	}

	public HelloServiceImpl(String name) {
		super();
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println("hello," + name);
	}

	@Override
	public void sayName() {
		System.out.println("name," + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
