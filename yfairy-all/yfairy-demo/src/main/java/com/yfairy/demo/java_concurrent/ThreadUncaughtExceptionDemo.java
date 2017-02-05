package com.yfairy.demo.java_concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadUncaughtExceptionDemo {

	public static void main(String[] args) {
		/**
		 * 为线程设置未捕获的异常处理器:<br>
		 * http://blog.csdn.net/hongxingxiaonan/article/details/50527169<br>
		 * //setUncaughtExceptionHandler设置异常处理器<br>
		 */

		Thread t = new ThreadWithEh();
		t.start();

	}

	static class ThreadWithEh extends Thread {

		public ThreadWithEh() {
			super();
			// setUncaughtExceptionHandler设置异常处理器
			this.setUncaughtExceptionHandler(new ExHandler());
		}

		@Override
		public void run() {
			// System.out.println(Thread.currentThread());
			throw new RuntimeException("throw RuntimeException333");
		}

	}

	static class ExHandler implements UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			CountDownLatch cd = new CountDownLatch(1);
			System.out.println("自定义线程未捕获异常处理器:start");
			e.printStackTrace();

			try {
				cd.await(100, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			cd.countDown();
			System.out.println("自定义线程未捕获异常处理器:end");
		}

	}

}
