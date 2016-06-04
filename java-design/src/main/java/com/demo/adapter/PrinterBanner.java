package com.demo.adapter;

public class PrinterBanner extends Banner implements Printer {

	public PrinterBanner(String string) {
		super(string);
	}

	public void princtWeek() {
		System.out.println("........................");
		showWithParen();
		System.out.println("........................");

	}

	public void princtStrong() {
		System.out.println("-------------------------------");
		showWithAster();
		System.out.println("-------------------------------");
	}

}
