package com.demo.deep.c19;
/**
 * 除了不能继承enum外，我们可以把enum看做一个类，并添加方法
 */
public enum ColorEnum {
	RED("RED"),BLUE("BLUE DESC"),GREEN("GREEN DESC");

	private String description;
	
	/**
	 * 通过构造方法，返回枚举类对自身的描述
	 */
	private ColorEnum(String description) {
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	
	
}
