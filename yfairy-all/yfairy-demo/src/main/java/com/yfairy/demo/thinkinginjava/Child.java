package com.yfairy.demo.thinkinginjava;

public class Child extends Parent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Child(String name) {
		// 当父类定义有参数构造函数时，子类必须使用super（参数) 调用父构造器
		super(name);
	}

	@Override
	protected String getName() {
		return super.getName();
	}

	public static void main(String[] args) {
		Parent parent = new Parent("111");
		System.out.println(parent.getName());
	}
}
