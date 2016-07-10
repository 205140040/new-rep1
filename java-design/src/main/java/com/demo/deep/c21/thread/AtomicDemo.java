package com.demo.deep.c21.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo extends Thread {

	/**
	 * 原子类 AtomicInteger,AtomicLong
	 * 原子类可以不用锁，达到同步，但是通常使用锁要安全些
	 */
	private AtomicInteger i = new AtomicInteger(0);

	public int getI() {
		return i.get();
	}

	@Override
	public void run() {
		for (int j = 0; j <= 20; j++) {
			System.out.println("currentThread:" + Thread.currentThread().getName() + "\ti:" + getI());
			i.addAndGet(1);
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		AtomicDemo ad = new AtomicDemo();
		for (int i = 0; i < 2; i++) {
			executorService.execute(ad);
		}
		executorService.shutdown();
		/**
		 * synchronized (this) {
			
		} 同步代码块,
		 */
		
	}

}
