package com.demo.visitor;

import java.util.Iterator;

public abstract class Entry implements Acceptor{
	public abstract String getName();

	public abstract int getSize();

	public Entry add(Entry entry) throws Exception {
		throw new Exception();
	}

	public Iterator<Entry> iterator() throws Exception {
		throw new Exception();
	}

	@Override
	public String toString() {
		return getName() + "(" + getSize() + ")";
	}
}
