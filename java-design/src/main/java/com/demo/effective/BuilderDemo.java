package com.demo.effective;

import java.util.Date;

public class BuilderDemo {
	private String name;
	private int age;
	private String sex;
	private Date bir;
	private String address;
	

	public BuilderDemo() {
		super();
	}

	/**
	 * 当有多个参数需要设置时，可以通过builder这种模式，减少构造方法
	 */
	public BuilderDemo name(String name) {
		this.name = name;
		return this;
	}

	public BuilderDemo sex(String sex) {
		this.sex = sex;
		return this;
	}

	public BuilderDemo address(String address) {
		this.address = address;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BuilderDemo [name=" + name + ", age=" + age + ", sex=" + sex + ", bir=" + bir + ", address=" + address
				+ "]";
	}

	public static void main(String[] args) {
		BuilderDemo builderDemo = new BuilderDemo().name("啦啦").sex("女女").address("黑色玫瑰");
		System.out.println(builderDemo);
	}
	
	

}
