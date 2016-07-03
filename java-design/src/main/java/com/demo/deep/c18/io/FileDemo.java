package com.demo.deep.c18.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\admin\\Desktop\\tio.txt");
		System.out.println("绝对路径:" + file.getAbsolutePath());
		System.out.println("can read:" + file.canRead());
		System.out.println("canWrite:" + file.canWrite());
		System.out.println("Name:" + file.getName());
		System.out.println("getParent:" + file.getParent());
		System.out.println("getPath:" + file.getPath());
		System.out.println("length:" + file.length());
		System.out.println("lastModified:" + file.lastModified());
		System.out.println("isDirectory:" + file.isDirectory());
		System.out.println("isFile:" + file.isFile());
		File file2 = new File("C:\\Users\\admin\\Desktop\\tiodir");
		if (!file2.exists()) {// 创建目录mkdirs
			/**
			 * mkdir（）创建此抽象路径名称指定的目录（及只能创建一级的目录，且需要存在父目录）
			 * 
			 * mkdirs（）创建此抽象路径指定的目录，包括所有必须但不存在的父目录。（及可以创建多级目录，无论是否存在父目录）
			 */
			file2.mkdirs();
		}
		File file3 = new File("C:\\Users\\admin\\Desktop\\tiodir\\tio2.txt");
		if (!file3.exists()) { // 创建文件:createNewFile
			try {
				boolean b = file3.createNewFile();
				System.out.println("文件创建结果:" + b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 删除delete
		file3.delete();
		if (file3.exists()) {
			// 重命名，或移动renameTo
			file3.renameTo(new File("C:\\Users\\admin\\Desktop\\tiorename.txt"));
		}
	}

}
