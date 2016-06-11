package com.demo.decorate;

public class StringDisplay extends Display {

	private String s;

	public StringDisplay(String s) {
		super();
		this.s = s;
	}

	@Override
	public int getRows() {
		return 1;
	}

	@Override
	public int getColumns() {
		return s.length();
	}

	@Override
	public String getRowText(int index) {
		if (index == 0) {
			return s;
		}
		return null;
	}

}
