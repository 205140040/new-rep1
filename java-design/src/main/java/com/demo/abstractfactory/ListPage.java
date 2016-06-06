package com.demo.abstractfactory;

public class ListPage extends Page {

	public ListPage(String title, String author) {
		super(title, author);
	}

	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>" + title + "，" + author + "\n");
		for (Object object : content) {
			Item item = (Item) object;
			buffer.append(item.makeHTML() + "\n");
		}
		buffer.append("</html>");
		return buffer.toString();
	}

}
