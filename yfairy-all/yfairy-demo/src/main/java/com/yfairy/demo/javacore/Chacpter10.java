package com.yfairy.demo.javacore;

import java.io.InputStream;

public class Chacpter10 {
	public static void main(String[] args) throws Exception {
		/**
		 * 第10章：部署应用程序和applet442/720<br>
		 * jar命令打包java jar cvf jarname *.classes<br>
		 * 如：jar cvf jar1.jar * <br>
		 * ，打包classes目录下所有的文件<br>
		 * Class获取资源<br>
		 */
		// class.getResourceAsStream 找到与类位于同一位置的资源
		InputStream in = Chacpter10.class.getResourceAsStream("Chacpter10.java");
		byte[] datas = new byte[in.available()];
		in.read(datas);
		System.out.println(new String(datas));
	}
}
