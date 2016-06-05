package com.demo.prototype;

public class MessageBox implements Product {

	private String name;
	
	

	public MessageBox(String name) {
		super();
		this.name = name;
	}

	public void use(String s) {
		System.out.println("name:" + name);
	}

	public Product createClone() {
		Product p = null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
