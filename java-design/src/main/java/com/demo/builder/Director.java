package com.demo.builder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		super();
		this.builder = builder;
	}

	public Object construct() {
		builder.makeTilte("Greeting");
		builder.makeString("从早上到白天结束");
		builder.makeItems(new String[] { "早安", "午安" });
		builder.makeString("到了晚上");
		builder.makeItems(new String[] { "晚安", "再见" });
		return builder.getResult();
	}
}
