package com.demo.builder;

public abstract class Builder {
	public abstract void makeTilte(String t);

	public abstract void makeString(String string);

	public abstract void makeItems(String[] items);

	public abstract Object getResult();
}
