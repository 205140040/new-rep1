package com.demo.prototype;

import java.util.Hashtable;

public class Manager {

	private Hashtable<String, Object> showCase = new Hashtable<String, Object>();

	public void register(String key, Object value) {
		showCase.put(key, value);
	}

	public Product create(String key) {
		Product p = (Product) showCase.get(key);
		return p.createClone();
	}
}
