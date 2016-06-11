package com.demo.decorate;

public class SideBorder extends Border {
	private char borderChar;

	public SideBorder(Display display, char c) {
		super(display);
		this.borderChar = c;
	}

	public int getColumns() {
		return 2 + display.getColumns();
	}

	public int getRows() {
		return display.getRows();
	}

	public String getRowText(int index) {
		return borderChar + display.getRowText(index) + borderChar;
	}
}
