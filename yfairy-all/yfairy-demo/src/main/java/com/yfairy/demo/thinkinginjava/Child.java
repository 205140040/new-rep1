package com.yfairy.demo.thinkinginjava;

public class Child extends Parent {

	@Override
	protected String getName() {
		return super.getName();
	}

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.getName();
	}
}
