package com.demo.deep.c18.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 旧的io已经用nio重新实现过，因此即使我们不显示的调用nio，也能从中受益
		 */
		//得到输入流管道
		FileChannel fChannel = new FileInputStream("C:\\Users\\admin\\Desktop\\tio2.txt").getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
		fChannel.read(byteBuffer); //读取类容
		System.out.println(new String(byteBuffer.array(), "GBK"));
		fChannel.close();
		//得到输出流管道
//		FileChannel out = new FileOutputStream("C:\\Users\\admin\\Desktop\\tio2.txt").getChannel();
//		byteBuffer.wrap("hello,酱紫,啦啦啦啦".getBytes());
//		System.out.println(new String(byteBuffer.array(), "GBK"));
//
//		out.write(byteBuffer);
		
	}

}
