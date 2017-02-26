package com.yfairy.demo.spring_in_action_2;

public class Parent {
	private String name;

	private String sex;

	public Parent() {
		super();
	}

	public Parent(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Parent [name=" + name + ", sex=" + sex + "]";
	}

}
