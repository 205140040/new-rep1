package com.demo.facade;

import java.io.IOException;
import java.io.Writer;

public class Htmlwriter {
	private Writer writer;

	public Htmlwriter(Writer writer) {
		super();
		this.writer = writer;
	}

	public void title(String title) throws IOException {
		writer.write("<html>");
		writer.write("<haed>");
		writer.write("<title>");
		writer.write(title);
		writer.write("</title>");
		writer.write("</haed>");
		writer.write("<body>/n");

	}

	// 输出段落
	public void p(String msg) throws IOException {
		writer.write("<p>");
		writer.write(msg);
		writer.write("</p>/n");
	}

	// 输出href
	public void href(String href, String hrefCon) throws IOException {
		writer.write("<a href=\"" + href + "\" >" + hrefCon + "</a>");
	}

	public void mailTo(String mailaddr, String username) throws IOException {
		href("mailTo:" + mailaddr, username);
	}

	public void close() throws IOException {
		writer.write("</body></html>/n");
		writer.close();
	}
}
