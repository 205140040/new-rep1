package com.yfairy.demo.javacore;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class GuojihuaDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 第5章：国际化261/858<br>
		 */
		// 创建locale对象
		Locale enlocale = new Locale("en", "US"); // 通过语言代码创建
		// java.util.Locale.Locale(String language, String country),通过语言和地区代码创建
		Locale cnlocale = new Locale("zh", "CN");
		// 通过内置方法创建
		Locale cnlocale2 = Locale.CHINA;
		System.out.println(enlocale);
		System.out.println(cnlocale);
		System.out.println(cnlocale2);

		// 格式化时使用locale
		NumberFormat ennf = NumberFormat.getCurrencyInstance(enlocale);
		double n1 = 3.1415926;
		System.out.println(ennf.format(n1));

		NumberFormat cnnf = NumberFormat.getCurrencyInstance(cnlocale2);
		System.out.println(cnnf.format(n1));

		// dateformat
		DateFormat endf = DateFormat.getDateInstance(DateFormat.FULL, enlocale);
		DateFormat cndf = DateFormat.getDateInstance(DateFormat.FULL, cnlocale2);
		System.out.println(endf.format(new Date()));
		System.out.println(cndf.format(new Date()));

		// 5.5消息格式化
		//MessageFormat.format 静态方法，使用占位符设置参数
		String msg1 = MessageFormat.format("你好啊{1},现在是{0}", cndf.format(new Date()), "tim");
		System.out.println(msg1);

		//ResourceBundle
		ResourceBundle enRb=ResourceBundle.getBundle("msg", enlocale);
		ResourceBundle cnRb=ResourceBundle.getBundle("msg", cnlocale2);
		System.out.println(enRb.getString("hello"));
		System.out.println(new String(cnRb.getString("hello").getBytes(),"UTF-8"));

	}

}
