package com.demo.abstractfactory;

public abstract class Item {
	protected String capation;

	public Item(String capation) {
		super();
		this.capation = capation;
	}
	public abstract String makeHTML();
}
