package com.yfairy.demo.spring_in_action_2;

public class BeanScope {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static BeanScope newInstance() {
		System.out.println("factory-method='' 设置工厂方法创建bean ");
		return new BeanScope();
	}

	public void initMethod(){
		System.out.println("initMethod设置初始化方法");
	}
	
	public void destroyMethod(){
		System.out.println("destroyMethod设置销毁方法");
	}
}
