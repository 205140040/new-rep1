package com.demo.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {

	private Database() { // 申明构造方法私有，无法new
		super();
	}

	public static Properties getProperties(String name) {//从数据库名称取得属性文件
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(name + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
