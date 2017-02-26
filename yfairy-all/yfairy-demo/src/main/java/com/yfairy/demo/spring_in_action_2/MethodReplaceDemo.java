package com.yfairy.demo.spring_in_action_2;

public class MethodReplaceDemo {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return "hello," + name;
	}

}
