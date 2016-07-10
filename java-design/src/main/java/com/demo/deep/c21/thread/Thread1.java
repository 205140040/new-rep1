package com.demo.deep.c21.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 继承自Thread实现多线程
 */
public class Thread1 extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Thread1 thread1=new Thread1();
		ExecutorService executorService=Executors.newCachedThreadPool();
		for (int i = 0; i < 6; i++) {
			executorService.execute(thread1);
		}
		executorService.shutdown();
	}
}
