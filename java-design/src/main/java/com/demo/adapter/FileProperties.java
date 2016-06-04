package com.demo.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileProperties extends Properties implements FileProp {

	/**
	 * @author admin 2016年6月4日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	public void loadFile(InputStream inStream) {
		try {
			load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveFile(OutputStream outputStream, String comments) {
		try {
			store(outputStream, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void set(String key, String value) {
		setProperty(key, value);
	}

}
