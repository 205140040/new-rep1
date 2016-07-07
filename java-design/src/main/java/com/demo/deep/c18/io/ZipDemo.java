package com.demo.deep.c18.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/**
		 * 压缩
		 * 
		 */
		// GZIPOutputStream
		/*
		 * String filePath = "C:\\Users\\admin\\Desktop\\tgz.gz";
		 * BufferedOutputStream gzipout = new BufferedOutputStream(new
		 * GZIPOutputStream(new FileOutputStream(filePath)));
		 * gzipout.write("hello,酱紫,露露".getBytes()); gzipout.close(); //
		 * GZIPInputStream BufferedInputStream gzipin = new
		 * BufferedInputStream(new GZIPInputStream(new
		 * FileInputStream(filePath))); byte[] bytes = new
		 * byte[gzipin.available()]; gzipin.read(bytes); System.out.println(new
		 * String(bytes, "GBK"));
		 */
		/**
		 * zip压缩
		 * ZipEntry压缩中的每个文件实体
		 * 调用zipoutputstream中的putNextEntry添加一个压缩的实体文件
		 * ZipFile=*.zip的文件
		 * 使用zipInputStream读取zipFile*.zip格式的文件
		 */
		// ZipOutputStream
		File zipEntryFile1 = new File("C:\\Users\\admin\\Desktop\\tio2.txt");
		ZipEntry zipEntry1 = new ZipEntry(zipEntryFile1.getName()); // 设置zip实体
		File zipoutFile = new File("C:\\Users\\admin\\Desktop\\tzip.zip");
		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipoutFile));
		zipOutputStream.putNextEntry(zipEntry1); // 添加到zipoutputstream中
		BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new FileInputStream(zipEntryFile1));
		byte[] b1 = new byte[bufferedInputStream1.available()];
		bufferedInputStream1.read(b1);
		zipOutputStream.write(b1);
		// 第二份压缩文件
		File file2 = new File("C:\\Users\\admin\\Desktop\\tio3.txt");
		BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
		byte[] b2 = new byte[bufferedInputStream2.available()];
		bufferedInputStream2.read(b2);
		zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
		zipOutputStream.write(b2);
		// 第三份压缩文件
		zipOutputStream.putNextEntry(new ZipEntry("tio5.txt"));
		zipOutputStream.write("tio5,啦啦啦啦啦".getBytes());

		bufferedInputStream1.close();
		bufferedInputStream2.close();
		zipOutputStream.close();
		System.out.println("压缩成功");
		
		//结合zipFile读取zip文件
		//ZipInputStream
		ZipFile zipInputFile=new ZipFile(zipoutFile); //获得zip格式的文件
		ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream(zipoutFile));
		ZipEntry zipEntryin1=zipInputStream.getNextEntry();
		InputStream in1=zipInputFile.getInputStream(zipEntryin1); //得到实体1的输入流
		byte[] bin1=new byte[in1.available()];
		in1.read(bin1);
		System.out.println(zipEntryin1.getName()+",类容："+new String(bin1,"GBK"));
		ZipEntry zipEntryin2=zipInputStream.getNextEntry();
		InputStream in2=zipInputFile.getInputStream(zipEntryin2); //得到实体1的输入流
		byte[] bin2=new byte[in2.available()];
		in2.read(bin2);
		System.out.println(zipEntryin2.getName()+",类容："+new String(bin2,"GBK"));
		zipInputFile.close();
		zipInputStream.close();
	}

}
