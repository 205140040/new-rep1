package com.demo.abstractfactory;

public class Test {
	public static void main(String[] args) {
		Factory factory = Factory.getFactory(ListFactory.class);
		Link link = factory.createLink("每日新闻", "http://news");
		Tray tray = factory.createTray("tray");
		tray.add(link);
		Page page = factory.createPage("page", "page");
		page.add(tray);
		page.output();
	}
}
