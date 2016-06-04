package com.demo.template;

public class StringDisplay extends AbstractDisplay {

	private String s;

	public StringDisplay(String s) {
		super();
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public void open() {
		System.out.println("--------------------------");
	}

	@Override
	public void print() {
		System.out.println(s);
	}

	@Override
	public void close() {
		System.out.println("--------------------------");
	}

}
