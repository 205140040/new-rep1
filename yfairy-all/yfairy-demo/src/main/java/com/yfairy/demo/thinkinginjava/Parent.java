package com.yfairy.demo.thinkinginjava;

import java.io.Serializable;

public class Parent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;

	public Parent() {
		super();
	}

	public Parent(String name) {
		super();
		this.name = name;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

}
