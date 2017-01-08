package com.yfairy.demo.javacore;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IoDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 第1章：流与文件<br>
		 * InputStream字节输入流 OutputStream字节输出流16/858<br>
		 * 1.4 zip文档42/858(看java开发实战经典压缩流)<br>
		 */
		/*
		 * // 获取用户目录 String userDir = System.getProperty("user.dir");
		 * System.out.println(userDir);
		 * 
		 * InputStream in = new FileInputStream(""); in.read(); // 读，当流结束时返回-1
		 * // 获取当前流中可读取的数量 in.available(); //
		 * 返回此输入流中可以读取（或跳过）的字节数的估计，而不受此输入流的下一个调用的阻塞。
		 * 
		 * // return the total number of bytes read into the buffer, or -1 if
		 * there // is no more data because the end of the stream has been
		 * reached.
		 * 
		 * // 读入缓冲区的总字节数，或者，如果没有流的结束，则没有更多的数据（1）。 // abstract int read();
		 * 从数据中读入一个字节，并返回读入的字节数量 // int java.io.InputStream.read(byte[] b)
		 * 读取一定数量的字节，返回读取的字节数
		 * 
		 * // long java.io.InputStream.skip(long n) 跳过n个字节
		 * 
		 * OutputStream out = new FileOutputStream(""); byte b = new Byte("1");
		 * out.write(b); // 写一个字节到文件中 // out.write(bytes, off, len);
		 * 从指定位置，写指定长度的字节 in.close(); out.close();
		 */
		// 获取用户目录
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);

		// 1.2文本输入与输出
		String desktop = "C:\\Users\\jiangzi\\Desktop";
		String filePath = desktop + File.separator + "iot1.txt";
		String file2Path = desktop + File.separator + "iot2.txt";

		InputStream in = new FileInputStream(filePath);
		byte[] bytes = new byte[in.available()];
		int readedCount = in.read(bytes);
		System.out.println("读取的字节数量:" + readedCount);
		System.out.println("类容:" + new String(bytes, "GBK"));

		// 使用reader读取文本
		System.out.println("--------------------------------");
		System.out.println("使用reader读取文本:");
		// InputStreamReader把输入流转换成Reader

		InputStreamReader ir = new InputStreamReader(new FileInputStream(file2Path), "UTF-8");

		// BufferedReader读取字符流文本
		BufferedReader reader = new BufferedReader(ir);
		// reader.readLine() 读取一行文本，结束时返回null
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		in.close();
		reader.close();

		// 1.2.4字符集
		// Charset

		// System.out.println("获取所有可用的字符集availableCharsets");
		// SortedMap<String, Charset> cs=Charset.availableCharsets();
		// for (Entry<String, Charset> e:cs.entrySet()) {
		// System.out.println(e.getKey()+"\t"+e.getValue());
		// }
		// 通过名字获取字符集
		Charset charset = Charset.forName("UTF-8");
		System.out.println(charset);

		// 1.3读取二进制数据

		// 压缩
		// 1.4 zip文档42/858(看java开发实战经典压缩流)<br>
		// 参考:http://blog.csdn.net/hanshileiai/article/details/6718375
		// InflaterInputStream 压缩类的基类
		// DeflaterOutputStream
		String zipoutFile = desktop + File.separator + "zout1.zip";

		// ZipOutputStream zip输出流
		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(zipoutFile));
		File f1 = new File(filePath);
		File f2 = new File(file2Path);

		// 创建一个ZipEntry 对象
		ZipEntry ze1 = new ZipEntry(f1.getName());
		zipout.putNextEntry(ze1);
		// 写一个文件
		zipout.write(copyToByteArray(new FileInputStream(f1)));

		// 创建一个ZipEntry 对象,并写出文件
		zipout.putNextEntry(new ZipEntry(f2.getName()));
		zipout.write(copyToByteArray(new FileInputStream(f2)));

		zipout.close();
		System.out.println("压缩success...");

		// 压缩文件夹，文件夹时需要添加f.getName()+"\\"
		// 参考http://zhangzhaoaaa.iteye.com/blog/2115048
		System.out.println("------压缩文件夹------");
		String zdirpath = desktop + File.separator + "zdirout1.zip";
		ZipOutputStream dirzipOut = new ZipOutputStream(new FileOutputStream(zdirpath));
		File zipDir = new File(desktop, "zipdir");
		File[] files = zipDir.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			if (!file.isDirectory()) { // 避免出现无法访问异常
				ZipEntry zipEntry = new ZipEntry(file.getName());
				dirzipOut.putNextEntry(zipEntry);
				dirzipOut.write(copyToByteArray(new FileInputStream(file)));
			} else {
				// 压缩目录
				ZipEntry zipEntry = new ZipEntry(file.getName() + "\\");
				dirzipOut.putNextEntry(zipEntry);

				// 获取目录中的文件，压缩
				File[] cfiles = file.listFiles();
				for (File file2 : cfiles) {
					dirzipOut.putNextEntry(new ZipEntry(file.getName() + "\\" + file2.getName()));
					dirzipOut.write(copyToByteArray(new FileInputStream(file2)));
				}
			}

		}

		// 自定义文件夹添加到压缩文件中
		dirzipOut.putNextEntry(new ZipEntry("cusdir1" + "\\"));
		dirzipOut.putNextEntry(new ZipEntry("cusdir1" + "\\" + f2.getName()));
		dirzipOut.write(copyToByteArray(new FileInputStream(f2)));

		/**
		 * TODO zip压缩目录<br>
		 * zip压缩目录(重要) 总结：<br>
		 * 压缩目录：dirzipOut.putNextEntry(new ZipEntry(dirname + "\\"));<br>
		 * (new ZipEntry("dir1" + "\\" + f2.getName()目录+目录下的文件名称)<br>
		 * 再压缩目录下的文件:dirzipOut.putNextEntry(new ZipEntry("cusdir1" + "\\" +
		 * f2.getName()));<br>
		 * 再写出目录下的文件:dirzipOut.write<br>
		 * dirzipOut.write(copyToByteArray(new FileInputStream(f2)));<br>
		 */

		dirzipOut.close();
		System.out.println("压缩文件夹success...");

		System.out.println("------读取压缩文件------");

	}

	public static byte[] copyToByteArray(InputStream in) throws IOException {
		int byteReadedCount = 0;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
			byteReadedCount = byteReadedCount + read;
		}
		out.flush();
		in.close();
		return out.toByteArray();
	}

}
