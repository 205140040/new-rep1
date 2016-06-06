package com.demo.abstractfactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Tray extends Item {

	protected List<Object> tray = new ArrayList<Object>();

	public Tray(String capation) {
		super(capation);
	}

	public void add(Item item) {
		tray.add(item);
	}
}
