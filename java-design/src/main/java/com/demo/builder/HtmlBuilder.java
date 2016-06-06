package com.demo.builder;

public class HtmlBuilder extends Builder {
	private StringBuffer buffer = new StringBuffer();

	@Override
	public void makeTilte(String t) {
		buffer.append("<html>\n");
		buffer.append("<h1>" + t + "</h1>\n");
		buffer.append("\n");
	}

	@Override
	public void makeString(String string) {
		buffer.append("\t<p>" + string + "</p>\n");
		buffer.append("\n");
	}

	@Override
	public void makeItems(String[] items) {
		for (String string : items) {
			buffer.append("\t<li>" + string + "</li>\t");
		}
		buffer.append("\n");
	}

	@Override
	public Object getResult() {
		buffer.append("</html>\n");
		return buffer.toString();
	}
}
