package com.demo.deep.c12;

import org.apache.log4j.Logger;

public class ExceptionTest {
	private static Logger logger = Logger.getLogger("ExceptionTest");

	public static void runtimeExceptionFun() {
		throw new RuntimeException1("发生了非检查型异常runexception1");
	}
	
	public static void e1  () throws Exception1 {
		throw new Exception1("发生了非检查型异常exception1");
	}

	
	/**
	 * 异常处理的原则：把错误处理的代码和，错误发生的地方隔离
	 */
	public static void main(String[] args) throws Exception1  {
		try {
			System.out.println("aaa");
			throw new NullPointerException(); // 扔出异常
		} catch (NullPointerException e) {
			// 打印异常
			e.printStackTrace();
		}
		try {
			System.out.println("bb");
			throw new Exception1("bbb运行出现了异常"); // 扔出异常
		} catch (Exception1 e) {
			// 打印异常
			e.printStackTrace();
			logger.info(e);
		}
		try {
			throw new Exception1("出现了exceiption1", 1);
		} catch (Exception1 e) {
			e.printStackTrace();
			// 打印异常栈轨迹
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				System.out.println(stackTraceElement);
			}
		}
		runtimeExceptionFun();
		/**
		 * 异常throws，不捕获，则程序将在异常出停止运行
		 */
		e1();
		System.out.println("------------");
	}

}
