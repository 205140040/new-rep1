package com.demo.composite;

public abstract class Entry {
	public abstract String getName();

	public abstract Integer getSize();

	public Entry add(Entry entry) throws Exception {
		throw new Exception();
	}

	public void printList() {
		printList("");
	}

	public abstract void printList(String s);

	@Override
	public String toString() {
		return getName() + ":" + getSize();
	}

}
