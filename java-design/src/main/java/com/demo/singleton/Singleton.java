package com.demo.singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
		super();
	}

	public static Singleton getInstance() {
		return singleton;
	}
}
