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

public class WordTemplateDemo {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

		/**
		 * 使用word模板，动态替换内容<br>
		 * http://elim.iteye.com/blog/2031335
		 * 
		 * 此方式不利于循环表格内容的模板输出,即循环时要写多个替换字段，<br>
		 * 如果循环的内容list大小不确定，此方式就没办法用了<br>
		 * freemarker： http://blog.csdn.net/wpydaguan/article/details/44984021
		 */
		String desktop = "C:\\Users\\jiangzi\\Desktop";

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
