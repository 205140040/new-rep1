package com.demo.decorate;

public class Test {
	public static void main(String[] args) {
		Display d1 = new StringDisplay("hello");
		Display d2 = new SideBorder(d1, '|');
		d1.show();
		d2.show();
	}
}
