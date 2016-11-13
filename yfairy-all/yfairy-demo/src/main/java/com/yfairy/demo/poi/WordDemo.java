package com.yfairy.demo.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordDemo {
	public static void main(String[] args) throws Exception {
		/**
		 * word:https://poi.apache.org/document/index.html
		 * http://www.w3ii.com/apache_poi_word/apache_poi_word_core_classes.html
		 * Apache POI Word核心类：<br>
		 * 1. XWPFDocument 这是org.apache.poi.xwpf.usermodel包下的类。
		 * 它被用来创建的MS-Word文档与.docx文件格式。<br>
		 * 2.XWPFParagraph:创建段落<br>
		 * 3.XWPFRun 这是org.apache.poi.xwpf.usermodel包下一个类，用于文本的区域添加到段。<br>
		 * 4.XWPFStyle:用于不同的样式添加到一个Word文档中的对象元素。 类方法：<br>
		 * 5.XWPFTable:用于表数据添加到Word文档<br>
		 * 6.XWPFWordExtractor:它是用于提取Word文档的简单文本基本的解析器类。
		 */

		/**
		 * 这篇文章写得很好：http://elim.iteye.com/blog/2031335
		 */

		/**
		 * 创建一个空白的word文件
		 */
		long start = System.currentTimeMillis();

		XWPFDocument xwpfDocument = new XWPFDocument();
		String desktop = "C:\\Users\\jiangzi\\Desktop";
		File wordFile = new File(desktop, "xwpdWord.docx");
		OutputStream out = new FileOutputStream(wordFile);
		/**
		 * 创建段落
		 */
		XWPFParagraph p1 = xwpfDocument.createParagraph();
		p1.setAlignment(ParagraphAlignment.CENTER);
		p1.setBorderBottom(Borders.DOUBLE);
		p1.setBorderTop(Borders.DOUBLE);

		p1.setBorderRight(Borders.DOUBLE);
		p1.setBorderLeft(Borders.DOUBLE);
		p1.setBorderBetween(Borders.SINGLE);

		p1.setVerticalAlignment(TextAlignment.TOP);

		XWPFRun p1run = p1.createRun();
		p1run.setBold(true);
		p1run.setText("段落1段落1段落1段落1段落1段落1段落1段落1段落1段落1段落1段落1段落1段落1段落1");
		p1run.setBold(true);
		p1run.setFontFamily("Courier");
		p1run.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
		p1run.setTextPosition(100);

		XWPFParagraph p2 = xwpfDocument.createParagraph();
		XWPFRun p2run = p2.createRun();
		p2run.setText("段落2段落2段落2段落2段落2段落2段落2.......");
		/**
		 * 段落中换行
		 */
		XWPFRun p1run2 = p2.createRun();
		p1run2.setText("p2run2");
		p1run2.addBreak();

		XWPFRun p1run3 = p2.createRun();
		p1run3.setText("p2run3");
		p1run3.addBreak();

		XWPFRun p1run4 = p2.createRun();
		p1run4.setText("p2run4");
		p1run4.addBreak();

		XWPFRun p1run5 = p2.createRun();
		p1run5.setText("p2run5");
		p1run5.addBreak();

		/**
		 * 创建table
		 */
		XWPFTable table1 = xwpfDocument.createTable(3, 3);
		XWPFTableRow row1 = table1.getRow(0);
		row1.getCell(0).setText("表格Demo");

		// 设置表格中显示段落
		XWPFParagraph tp1 = (XWPFParagraph) table1.getRow(0).getCell(2).getParagraphs().get(0);
		XWPFRun r1 = tp1.createRun();
		r1.setText("ParagraphCellText");

		// 在该行后面新增cell

		row1.addNewTableCell().setText("col two, row one");
		row1.addNewTableCell().setText("col three, row one");

		XWPFTableRow row2 = table1.getRow(1);
		row2.getCell(0).setText("1");
		row2.getCell(1).setText("2");
		row2.getCell(2).setText("3");

		xwpfDocument.write(out);
		out.close();
		xwpfDocument.close();

		/**
		 * 获取word内容
		 */
		XWPFDocument inDocument = new XWPFDocument(new FileInputStream(wordFile));
		XWPFWordExtractor we = new XWPFWordExtractor(inDocument);
		System.out.println(we.getText());
		we.close();

		/**
		 * 使用word模板，动态替换内容
		 */
		File templateWord = new File(desktop, "template.doc");
		InputStream inputStream = new FileInputStream(templateWord);
		HWPFDocument templateDoc = new HWPFDocument(inputStream);
		Range range = templateDoc.getRange();

		List<String> replaceFields = Arrays.asList("nowDate", "man1.name", "man1.sex", "man1.age", "man1.birthday",
				"man1.money", "man1.marry", "man2.name", "man2.sex", "man2.age", "man2.birthday", "man2.money",
				"man2.marry", "page2.title", "page2.tableContent");
		List<String> replaceFieldValues = new ArrayList<>();
		replaceFieldValues.add((new Date()).toLocaleString());

		List<Man> sourceList = new ArrayList<>();
		Man m1 = new Man("张三", 18, "哈哈", new Date(), new BigDecimal(8888), false);
		Man m2 = new Man("李思", 19, "哈哈", new Date(), new BigDecimal(8881), true);
		sourceList.add(m1);
		sourceList.add(m2);
		for (int i = 0; i < sourceList.size(); i++) {
			Man man = sourceList.get(i);
			replaceFieldValues.add(man.getName());
			replaceFieldValues.add(man.getSex());
			replaceFieldValues.add(man.getAge().toString());
			replaceFieldValues.add(man.getBirthday().toLocaleString());
			replaceFieldValues.add(man.getMoney().toString());
			replaceFieldValues.add(new Boolean(man.isMarry()).toString());
		}
		replaceFieldValues.add("Page2Tile");
		replaceFieldValues.add("Page2表格内容");

		for (int i = 0; i < replaceFields.size(); i++) {
			String field = replaceFields.get(i);
			String temp = "${" + field + "}";
			range.replaceText(temp, replaceFieldValues.get(i));
		}
		File templateOutFile = new File(desktop, "templateOutFile.doc");
		OutputStream outputStream = new FileOutputStream(templateOutFile);
		templateDoc.write(outputStream);

		inputStream.close();
		outputStream.close();

		long end = System.currentTimeMillis();
		long sub = end - start;
		System.out.println("succe:" + sub + "毫秒.");
	}
}
