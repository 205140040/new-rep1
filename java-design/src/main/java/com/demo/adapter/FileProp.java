package com.demo.adapter;

import java.io.InputStream;
import java.io.OutputStream;

public interface FileProp {
	void loadFile(InputStream inStream);

	void saveFile(OutputStream outputStream, String comments);

	void set(String key, String value);
}
