package com.demo.deep.c17;
/**
 * 普通类，未实现比较方法，存入set中，看是否能重复
 */
public class NormalSetType {
	protected int i;

	public NormalSetType(int i) {
		super();
		this.i = i;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
