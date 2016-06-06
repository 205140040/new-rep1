package com.demo.abstractfactory;

public class ListLink extends Link {

	public ListLink(String capation, String url) {
		super(capation, url);
	}

	@Override
	public String makeHTML() {
		return "<li><a href=" + url + ">" + capation + "</a></li>";
	}

}
