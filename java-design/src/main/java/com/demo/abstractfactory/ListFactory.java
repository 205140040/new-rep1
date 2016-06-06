package com.demo.abstractfactory;

public class ListFactory extends Factory {

	@Override
	public Link createLink(String capation, String url) {
		return new ListLink(capation, url);
	}

	@Override
	public Tray createTray(String capation) {
		return new ListTray(capation);
	}

	@Override
	public Page createPage(String title, String author) {
		return new ListPage(title, author);
	}

}
