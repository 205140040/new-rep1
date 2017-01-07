package com.yfairy.demo.javacore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread2 extends Thread {
	public static int count = 1;

	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		
		/*synchronized (this) {
			count++;
			System.out.println(Thread.currentThread() + "\tcount:" + count);
		}*/
	}
}
