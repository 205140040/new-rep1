package com.yfairy.demo.itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

public class ItextDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * ITEXT7官方文档:<br>
		 * http://developers.itextpdf.com/content/itext-7-jump-start-tutorial/chapter-1-introducing-basic-building-blocks
		 */
		long start = System.currentTimeMillis();
		String basePath = "C:\\Users\\jiangzi\\Desktop";
		File pdfFile = new File(basePath, "pdf1.pdf");
		OutputStream outputStream = new FileOutputStream(pdfFile);

		PdfWriter pdfWriter = new PdfWriter(outputStream);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		document.add(new Paragraph("Hello World,你好啊!"));

		// Create a PdfFont
		PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
		// Add a Paragraph
		document.add(new Paragraph("iText is:").setFont(font));
		// Create a List
		List list = new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font);
		// Add ListItem objects
		list.add(new ListItem("Never gonna give you up")).add(new ListItem("Never gonna let you down"))
				.add(new ListItem("Never gonna run around and desert you"))
				.add(new ListItem("Never gonna make you cry")).add(new ListItem("Never gonna say goodbye"))
				.add(new ListItem("Never gonna tell a lie and hurt you"));
		// Add the list
		document.add(list);

		// Document document = new Document();
		//
		// PdfWriter writer = PdfWriter.getInstance(document,
		// new FileOutputStream("pdf.pdf"));
		// document.open();
		// XMLWorkerHelper.getInstance().parseXHtml(writer, document,
		// new FileInputStream(new File(basePath, "freemarker1.html")));

		document.close();

		outputStream.close();
		pdfWriter.close();

		long end = System.currentTimeMillis();
		long sub = end - start;
		System.out.println("succe:" + sub + "毫秒.");
	}

}
