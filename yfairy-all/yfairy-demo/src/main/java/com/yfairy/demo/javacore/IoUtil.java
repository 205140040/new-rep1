package com.yfairy.demo.javacore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

/**
 * 
 * @author jiangzi
 *
 */
public class IoUtil {

	private static final int DEFAULT_BUFFER = 4096;

	public static void main(String[] args) throws Exception {
		String desktop = "C:\\Users\\jiangzi\\Desktop";
		File sourcef1 = new File(desktop + File.separator + "bi2.png");
		File cp1 = new File(desktop + File.separator + "bi2cp1.png");
		File cp2 = new File(desktop + File.separator + "bi2cp2.png");

		// 移动的文件
		File cp3 = new File(desktop + File.separator + "bi2cp3.png");
		File mv1 = new File("E:\\" + File.separator + "bi2cp3.png");

		InputStream in = new FileInputStream(sourcef1);
		OutputStream out = new FileOutputStream(cp1);
		copyInToOut(in, out);
		in.close();
		out.close();

		InputStream in2 = IoUtil.class.getResourceAsStream("IoUtil.java");
		byte[] datas = copyInToByteArray(in2);
		System.out.println(new String(datas, "UTF-8"));
		in2.close();

		copyFile(sourcef1, cp2);
		copyFile(sourcef1, cp3);
		moveFile(cp3, mv1);
		Logger.getGlobal().info("success...");

	}

	/**
	 * @description 复制文件，如果目标文件存在时复制并替换
	 * @param source
	 *            原始文件
	 * @param target
	 *            目标文件
	 */
	public static void copyFile(File source, File target) {
		try {
			Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description 移动文件，如果目标文件存在时移动并替换
	 * @param source
	 *            原始文件
	 * @param target
	 *            目标文件
	 */
	public static void moveFile(File source, File target) {
		try {
			Files.move(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description 读入输入流中的数据，写出到输出流
	 * @param in
	 *            输入流
	 * @param out
	 *            输出流
	 * @remark 方法没关闭流，需要自己关闭流
	 * @return 读取字节的总长度
	 */
	public static int copyInToOut(InputStream in, OutputStream out) {
		int totalReaded = 0;
		try {
			byte[] buffer = new byte[DEFAULT_BUFFER];
			int readed;
			while ((readed = in.read(buffer)) != -1) {
				out.write(buffer, 0, readed);
				totalReaded = totalReaded + readed;
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalReaded;
	}

	/**
	 * @description 读入输入流中的数据，复制到字节数组中
	 * @remark 方法没关闭输入流，需要自己关闭流
	 * @param in
	 * @return 输入流中的字节
	 */
	public static byte[] copyInToByteArray(InputStream in) {
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		copyInToOut(in, byteArrayOut);
		byte[] result = byteArrayOut.toByteArray();
		try {
			byteArrayOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
