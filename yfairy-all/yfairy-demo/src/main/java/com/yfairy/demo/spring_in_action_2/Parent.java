package com.yfairy.demo.spring_in_action_2;

public class Parent {
	private String name;

	private String sex;

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
