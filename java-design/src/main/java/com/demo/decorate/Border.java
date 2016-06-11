package com.demo.decorate;

public abstract class Border extends Display {
	protected Display display;

	public Border(Display display) {
		super();
		this.display = display;
	}

}
