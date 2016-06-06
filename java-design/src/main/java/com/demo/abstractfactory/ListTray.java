package com.demo.abstractfactory;

public class ListTray extends Tray {

	public ListTray(String capation) {
		super(capation);
	}

	@Override
	public String makeHTML() {
		return "<p>" + capation + "</p>";
	}

}
