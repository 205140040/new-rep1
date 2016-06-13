package com.demo.chain;

public class Trouble {
	private int number;//问题编号

	public Trouble(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Trouble [number=" + number + "]";
	}
	

}
