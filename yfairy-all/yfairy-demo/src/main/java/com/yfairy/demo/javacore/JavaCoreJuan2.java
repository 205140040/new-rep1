package com.yfairy.demo.javacore;

import java.io.FileInputStream;
import java.io.InputStream;

public class JavaCoreJuan2 {

	public static void main(String[] args) throws Exception {
		/**
		 * 第2卷:<br>
		 * 第1章：流与文件16/858<br>
		 * 第2章：XML91/858<br>
		 */
		InputStream in = new FileInputStream("");
		in.read(); // 读，当流结束时返回-1

	}

}
