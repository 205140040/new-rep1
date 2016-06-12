package com.demo.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry {

	private String name;
	private List<Entry> directory = new ArrayList<Entry>();
	
	

	public Directory(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		int size = 0;
		for (Entry entry : directory) {
			size = size + entry.getSize();
		}
		return size;
	}

	@Override
	public Entry add(Entry entry) throws Exception {
		directory.add(entry);
		return this;
	}

	@Override
	public Iterator<Entry> iterator() throws Exception {
		return directory.iterator();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
