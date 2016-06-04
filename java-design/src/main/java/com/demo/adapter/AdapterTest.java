package com.demo.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AdapterTest {

	public static void main(String[] args) throws FileNotFoundException {
		Printer printer = new PrinterBanner("啦啦啦啦");
		printer.princtWeek();
		printer.princtStrong();
		
		FileProp fileProp=new FileProperties();
		fileProp.set("a", "a1");
		File file=new File("C://Users//admin//Desktop//fileAdapter.txt");
		fileProp.saveFile(new FileOutputStream(file), "8888");
		System.out.println("成功");
	}

}
