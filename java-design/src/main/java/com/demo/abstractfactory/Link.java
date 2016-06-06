package com.demo.abstractfactory;

public abstract class Link extends Item {
	protected String url;

	public Link(String capation, String url) {
		super(capation);
		this.url = url;
	}

}
