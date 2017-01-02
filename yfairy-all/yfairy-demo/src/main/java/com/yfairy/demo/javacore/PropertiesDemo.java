package com.yfairy.demo.javacore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception, IOException {
		/**
		 * * 10.4.1属性映射文件476/720<br>
		 */
		Properties properties = new Properties();
		properties.put("name", "zhangsan");
		properties.put("age", "18");
		// 保存属性文件store
		String deskTop = "C:\\Users\\jiangzi\\Desktop";
		String fileName = deskTop + File.separator + "p1.properties";
		properties.store(new FileOutputStream(fileName), "properties1");
		// 从文件中读取属性文件load
		Properties p2 = new Properties();
		p2.load(new FileInputStream(fileName));
		System.out.println(p2.getProperty("name"));

		System.out.println("success...");
	}

}
