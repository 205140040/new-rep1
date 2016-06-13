package com.demo.facade;

import java.io.FileWriter;
import java.util.Properties;

public class PageMaker {

	private PageMaker() {
		super();
	}
	
	/**
	 * 把复杂的处理提供一个单一简单的接口
	 */
	public static void makeWelcomePage(String mailaddr,String filename){
		try {
			//Properties properties=Database.getProperties("maildata");
			String username="zhangsan";
			Htmlwriter htmlwriter=new Htmlwriter(new FileWriter(filename));
			htmlwriter.title("lala");
			htmlwriter.p("hahhahahah");
			htmlwriter.mailTo(mailaddr, username);
			htmlwriter.close();
			System.out.println("输出成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
