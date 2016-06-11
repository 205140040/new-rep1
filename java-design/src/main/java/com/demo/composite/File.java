package com.demo.composite;

public class File extends Entry {

	private String name;

	private int size;

	public File(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getSize() {
		return size;
	}

	@Override
	public void printList(String s) {
		System.out.println(s + "/" + this);
	}

}
