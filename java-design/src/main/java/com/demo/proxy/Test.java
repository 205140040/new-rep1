package com.demo.proxy;

public class Test {
	public static void main(String[] args) {
		Printable printable=new PrinterProxy("alice");
		System.out.println("现在的名称是:"+printable.getPinterName());
		printable.setPinterName("bob");
		System.out.println("现在的名称是:"+printable.getPinterName());
		printable.print("hello");
	}
}
