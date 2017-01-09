package com.yfairy.demo.javacore;

import java.io.Serializable;

public class SerStudent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private Integer age;

	/**
	 * 不序列化的字段
	 */
	private transient String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "SerStudent [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
