package com.demo.strategy;

public class StringPrint implements Print {
	private String s;

	public StringPrint(String s) {
		super();
		this.s = s;
	}

	public void print() {
		System.out.println(s);
	}

}
