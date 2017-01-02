package com.yfairy.demo.javacore;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class ExceptionDemo {

	public static void main(String[] args) {
		/**
		 * 第11章异常，断言日志和调试487/720<br>
		 * 11.1异常分类,异常都是派生于Throwable类的<br>
		 * java语言规范将派生于Error类和RuntimeException的类的所有异常称为未检查异常（非受检异常），<br>
		 * 其他异常称为已检查异常,编译器将检查是否为已检查异常提供异常处理器<br>
		 * 11.2.5分析堆栈跟踪元素<br>
		 * 11.3使用异常机制的技巧506/720<br>
		 * 11.4使用断言508/720<br>
		 * 11.5记录日志<br>
		 */
		// 异常处理的方式:1throws IOException, MyException 声明异常，2或try catch 捕获异常
		// 如果程序的异常没有捕获，程序就会终止
		/**
		 * 捕获多个异常: try { openUrl("https://www.baidu.com"); } catch (IOException
		 * e) { e.printStackTrace(); } catch (MyException e) {
		 * e.printStackTrace(); } <br>
		 * 1.7可以:<br>
		 * catch (IOException | MyException e)
		 */

		try {
			openUrl("111https://www.baidu.com");
		} catch (IOException | MyException e) {
			e.printStackTrace();

			System.out.println("--------------");

			// 分析堆栈跟踪元素
			StackTraceElement[] stackTraceElements = e.getStackTrace();
			for (StackTraceElement stackElement : stackTraceElements) {
				System.out.println(stackElement);
			}
			System.out.println("--------------");

			// catch异常中扔出异常，再次抛出异常
			try {
				throw new MyException("catch异常中扔出异常，再次抛出异常");
			} catch (MyException e1) {
				e1.printStackTrace();
			}
		} finally {
			System.out.println("无论是否出现异常,最终都会执行此处代码,可用于关闭资源");
		}
		// openUrl("https://www.baidu.com");
		System.out.println();
		System.out.println("异常后的代码");
		System.out.println("----------------------------");
		try {
			URL u2 = new URL("https://www.baidu.com");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("无论是否出现异常,最终都会执行此处代码,可用于关闭资源");
		}

		// 分析堆栈跟踪元素
		Throwable t = new Throwable();
		StackTraceElement[] stackTraceElements = t.getStackTrace();
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			System.out.println(stackTraceElement);
		}

		// 断言
		// 开启断言
		ExceptionDemo.class.getClassLoader().setDefaultAssertionStatus(true);
		Integer a = null;
		assert a != null;
		System.out.println(a);
		//
		// 11.5记录日志<br>
//		Logger.getGlobal().setLevel(newLevel);设置级别
		Logger.getGlobal().info("Logger.getGlobal().info");
		Logger.getGlobal().warning("waring");

	}

	// 创建异常类
	static class MyException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyException() {
			super();
		}

		public MyException(String message) {
			super(message);
		}

	}

	public static String openUrl(String urlStr) throws IOException, MyException {
		URL url = new URL(urlStr);
		InputStream in = url.openStream();
		// 抛出一个异常
		throw new MyException("throw一个异常");
	}

}
