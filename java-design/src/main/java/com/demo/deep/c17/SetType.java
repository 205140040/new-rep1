package com.demo.deep.c17;

public class SetType {
	protected int i;

	public SetType(int i) {
		super();
		this.i = i;
	}

	/**
	 * 存入set中的元素是唯一的，应为set不保存重复的元素, 加入set中的元素必须定义equals方法，以保证元素的唯一
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SetType && (i == ((SetType) obj).i);
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
