package com.demo.deep.c21.thread;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OtherDemo implements Runnable{

	public static void main(String[] args) {
		/**
		 * 定时运行线程
		 */
		ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(10);
		System.out.println("当前时间:"+new Date().toLocaleString());
		executor.schedule(new OtherDemo(), 10000, TimeUnit.MILLISECONDS);
		executor.shutdown();
	}

	public void run() {
		System.out.println(""+Thread.currentThread().getName());
		System.out.println("当前时间:"+new Date().toLocaleString());
	}

}
