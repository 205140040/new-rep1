package com.demo.deep.c14;

public abstract class Shape {
	public void draw() {
		System.out.println(this + ":draw()");
	}

	public abstract String toString();
}
