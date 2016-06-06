package com.demo.abstractfactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {

	protected String title;
	protected String author;

	protected List<Object> content = new ArrayList<Object>();

	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void add(Item item) {
		content.add(item);
	}

	public void output() {
		String fielName = title + ".html";
		try {
			Writer writer = new FileWriter(fielName);
			writer.write(this.makeHTML());
			writer.close();
			System.out.println("成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract String makeHTML();
}
