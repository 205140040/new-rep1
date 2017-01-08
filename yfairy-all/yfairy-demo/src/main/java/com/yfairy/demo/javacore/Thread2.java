package com.yfairy.demo.javacore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread2 extends Thread {
	public static int count = 1;
	/**
	 * 原子变量，在并发时无需同步
	 */
	public static volatile int vcount = 1;

	private static Map<String, String> normalMap = new HashMap<>();

	/**
	 * 并发map
	 */
	private static Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

	@Override
	public void run() {
		// try {
		// Thread.sleep(300);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// 同步方式1.同步代码块,或synchronized method同步方法
		// synchronized (mutex) {
		//
		// }
		// 2.使用
		// Lock lock=new ReentrantLock();
		// lock.lock();

		Lock lock = new ReentrantLock();
		lock.tryLock(); // 加锁
		try {
			count++;
			System.out.println(Thread.currentThread() + "\tcount:" + count);

		} finally {
			// 无论是否有异常都要释放锁
			lock.unlock();
		}

		/**
		 * 原子变量，在并发时无需同步
		 */
		vcount++;
		System.out.println(Thread.currentThread() + "\tvcount:" + vcount);

		/*
		 * synchronized (this) { count++;
		 * System.out.println(Thread.currentThread() + "\tcount:" + count); }
		 */

		try {
			Thread.sleep(300);
			normalMap.put("1", "1");
			System.out.println("normal:" + new String(normalMap.get("1").getBytes()));
			concurrentHashMap.put("1", "1");
			System.out.println("concurrentHashMap:" + new String(concurrentHashMap.get("1").getBytes()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
