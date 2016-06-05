package com.demo.factory;

public class IdCard extends Product {

	private String owner;

	public IdCard(String owner) {
		super();
		System.out.println("建立" + owner + "的卡");
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public void use() {
		System.out.println("使用" + this.owner + "的卡");
	}

}
