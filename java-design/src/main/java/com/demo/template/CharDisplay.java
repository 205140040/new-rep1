package com.demo.template;

public class CharDisplay extends AbstractDisplay {
	private char c;

	public CharDisplay() {
		super();
	}

	public CharDisplay(char c) {
		super();
		this.c = c;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	@Override
	public void open() {
		System.out.print("<<");

	}

	@Override
	public void print() {
		System.out.print(c + "\t");
	}

	@Override
	public void close() {
		System.out.println(">>");
	}

}
