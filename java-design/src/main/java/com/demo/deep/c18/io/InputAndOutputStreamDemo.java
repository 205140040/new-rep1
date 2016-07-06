package com.demo.deep.c18.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;

public class InputAndOutputStreamDemo {

	public static void main(String[] args) {
		// reader缓冲输入文件
		try {
			String file = "C:\\Users\\admin\\Desktop\\tio.txt";
			BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\tio.txt"));
			StringBuilder stringBuilder = new StringBuilder();
			// 当readLine返回null时就到了文件的末尾
			String s;
			while (null != (s = bufferedReader.readLine())) {
				stringBuilder.append(s + "\n");
			}
			System.out.println(stringBuilder.toString());
			bufferedReader.close();
			// StringReader
			StringReader stringReader = new StringReader(stringBuilder.toString());
			int c;
			while ((c = stringReader.read()) != -1) {
				// 一次读取一个字符
				System.out.print((char) c);
			}
			System.out.println();
			stringReader.close();
			// fileinputstream
			System.out.println("fileinputstream--------------");
			FileInputStream fileInputStream = new FileInputStream(file);
			int i;
			while ((i = fileInputStream.read()) != -1) {
				// 一次读取一个字符
				System.out.print((char) i);
			}
			System.out.println();

			fileInputStream.close();

			/**
			 * 输出流 buffered缓冲能提升io的性能 FileWriter可以向文件中写数据
			 */
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("jiangzi,hello\n" + "lalala\n" + "hahaha\n" + "wtiter");
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			printWriter.println("tab");
			printWriter.println("llalala");
			printWriter.println("hahaha");
			bufferedWriter.close();
			printWriter.close();
			/**
			 * dataINputStream dataOutputStream
			 */
			System.out.println("-------------dataINputStream dataOutputStream------------------");
			DataOutputStream dataOutputStream = new DataOutputStream(
					new FileOutputStream("C:\\Users\\admin\\Desktop\\dataIo.txt"));
			dataOutputStream.writeUTF("你好啊，啦啦啦");
			dataOutputStream.writeDouble(3.123);
			dataOutputStream.writeDouble(3.125);
			dataOutputStream.writeDouble(5.126);
			// dataInputStream
			System.out.println("dataInputStream---------------");
			DataInputStream dataInputStream = new DataInputStream(
					new FileInputStream("C:\\Users\\admin\\Desktop\\dataIo.txt"));
			System.out.println(dataInputStream.readUTF());
			System.out.println(dataInputStream.readDouble());
			System.out.println(dataInputStream.readDouble());
			System.out.println(dataInputStream.readDouble());

			dataOutputStream.close();
			dataInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
