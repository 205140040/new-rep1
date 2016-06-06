package com.demo.builder;

public class TextBuilder extends Builder {

	private StringBuffer buffer = new StringBuffer();

	@Override
	public void makeTilte(String t) {
		buffer.append("=====================\n");
		buffer.append("[" + t + "]\n");
		buffer.append("\n");
	}

	@Override
	public void makeString(String string) {
		buffer.append("\t<<" + string + ">>\n");
		buffer.append("\n");
	}

	@Override
	public void makeItems(String[] items) {
		for (String string : items) {
			buffer.append("\t" + string + "\t");
		}
		buffer.append("\n");
	}

	@Override
	public Object getResult() {
		buffer.append("=====================\n");
		return buffer.toString();
	}

}
