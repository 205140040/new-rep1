package com.demo.builder;

public class Test {
	public static void main(String[] args) {
		// 监工
		Builder tBuilder = new TextBuilder();
		Director director1 = new Director(tBuilder);
		System.out.println((String) director1.construct());
		Builder hBuilder = new HtmlBuilder();
		Director director2 = new Director(hBuilder);
		System.out.println((String) director2.construct());
	}
}
