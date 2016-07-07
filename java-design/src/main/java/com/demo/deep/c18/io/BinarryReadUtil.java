package com.demo.deep.c18.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

public class BinarryReadUtil {
	public static final int BUFFER_SIZE = 4096;

	public static byte[] inputStreamToByteArray(File file) {
		BufferedInputStream bufferedInputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			// bufferedInputStream.available() available()返回的实际可读字节数，也就是总大小
			/**
			 * read() :
			 * 从输入流中读取数据的下一个字节，返回0到255范围内的int字节值。如果因为已经到达流末尾而没有可用的字节，则返回-1。
			 * 在输入数据可用、检测到流末尾或者抛出异常前，此方法一直阻塞。
			 * 
			 * read(byte[] b) : 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b
			 * 中。以整数形式返回实际读取的字节数。在输入数据可用、检测到文件末尾或者抛出异常前，此方法一直阻塞。
			 * 
			 * 如果 b 的长度为 0，则不读取任何字节并返回 0；否则，尝试读取至少一个字节。如果因为流位于文件末尾而没有可用的字节，则返回值
			 * -1；否则，至少读取一个字节并将其存储在 b 中。
			 * 
			 * 将读取的第一个字节存储在元素 b[0] 中，下一个存储在 b[1] 中，依次类推。读取的字节数最多等于b 的长度。设 k
			 * 为实际读取的字节数；这些字节将存储在 b[0] 到 b[k-1] 的元素中，不影响 b[k] 到b[b.length-1]
			 * 的元素。
			 */
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int b;
			while (-1 != (b = bufferedInputStream.read())) {
				byteArrayOutputStream.write(b);
			}
			// bufferedInputStream.read(bytes);
			bufferedInputStream.close();
			byte[] bytes = byteArrayOutputStream.toByteArray();
			byteArrayOutputStream.close();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] inputStreamToByteArray2(File file) {
		BufferedInputStream bufferedInputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			byte[] bytes = new byte[BUFFER_SIZE];
			bufferedInputStream.read(bytes);
			bufferedInputStream.close();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] read(String filePath) {
		File file = new File(filePath);
		return inputStreamToByteArray(file);
	}

	public static void main(String[] args) {
		/**
		 * outputStream: void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
		 * void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len
		 * 个字节写入此输出流。 abstract void write(int b) 将指定的字节写入此输出流。
		 */
		try {
			System.out.println(new String(read("C:\\Users\\admin\\Desktop\\tio2.txt"), "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
