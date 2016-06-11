package com.demo.composite;

import java.util.ArrayList;
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

	/**
	 * 组合设计模式，目录和文件都有同样的方法，用递归求出size
	 */
	@Override
	public Integer getSize() {
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
	public void printList(String s) {
		System.out.println(s + "/" + this);
		for (Entry entry : directory) {
			entry.printList(s + "/" + name);
		}
	}

}
