package com.demo.decorate;

public abstract class Display {
	public abstract int getRows();

	public abstract int getColumns();

	public abstract String getRowText(int index);// 取得第row个字符

	public final void show() {
		for (int i = 0; i < getRows(); i++) {
			System.out.println(getRowText(i));
		}
	}
}
