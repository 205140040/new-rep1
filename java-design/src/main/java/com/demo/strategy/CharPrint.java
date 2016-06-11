package com.demo.strategy;

public class CharPrint implements Print {

	private char[] c;

	public CharPrint(char[] c) {
		super();
		this.c = c;
	}

	public void print() {
		for (char d : c) {
			System.out.print(d);
		}
		System.out.println();
	}

}
