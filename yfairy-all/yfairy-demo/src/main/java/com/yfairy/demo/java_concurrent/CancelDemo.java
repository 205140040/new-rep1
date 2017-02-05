package com.yfairy.demo.java_concurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CancelDemo {

	public  static void main(String[] args) throws InterruptedException {
		/**
		 * 第7章：任务取消与关闭125/308<br>
		 * 通常中断是实现取消的最合理的方式<br>
		 * 使用interrupt，代替取消标志<br>
		 * Thread.currentThread().isInterrupted()线程中断时返回true,<br>
		 * interrupt(); 调用中断方法，修改线程状态为中断<br>
		 * 7.2停止基于线程的服务138/308<br>
		 */
		ExecutorService es = Executors.newFixedThreadPool(10);
		CancelThread ct = new CancelThread();
		
		// ct.cancel();
//		es.execute(ct);
		
		InterruptedThread t2=new InterruptedThread();
		t2.start(); //启动
		Thread.sleep(50);
		t2.cancel(); //中断,中断不能配合执行器运行，且在线程开始前运行中断也无效

//		es.shutdown();
		
		//定时执行线程
		//http://blog.csdn.net/tsyj810883979/article/details/8481621
		ScheduledExecutorService ses=Executors.newScheduledThreadPool(1);
		Runnable r1=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello");
				
			}
		};
		ses.scheduleAtFixedRate(r1 , 0, 100, TimeUnit.MILLISECONDS); //周期执行线程
		Thread.sleep(500);
		ses.shutdown();
	}

	static class CancelThread extends Thread {
		/**
		 * 取消标志，volatile修饰
		 */
		private volatile boolean cancleFlag = false;

		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			if (false == cancleFlag) {
				// 为true时取消运行
				System.out.println(new Date().toLocaleString());
			}
		}

		public void cancel() {
			cancleFlag = true;
			System.err.println("取消成功...");
		}
	}
	
	static class InterruptedThread extends Thread {
		/**
		 * 使用interrupt，代替取消标志
		 */

		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			while (!Thread.currentThread().isInterrupted()) {
				// 为true时取消运行,非中断时运行
				System.out.println(new Date().toLocaleString());
			}
		}

		public void cancel() {
			interrupt(); //调用中断方法，修改线程状态为中断
			System.err.println("取消成功...");
		}
	}

}
