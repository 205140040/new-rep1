package com.demo.deep.c21.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenGenerator extends IntGenerator{
	
	private int currentVal=0;

	/**
	 * 加锁解决资源共享
	 * public synchronized int next() {
		++currentVal;
		++currentVal;
		return currentVal;
	}
	 */
	
	@Override
	public  int next() {
		/**
		 * 使用显式的锁对象Lock
		 */
		Lock lock=new ReentrantLock();
		try {
			lock.lock();
			++currentVal;
			++currentVal;
			return currentVal;
		} finally {
			lock.unlock();
		}
	}

	public static String finallyTest(){
		try {
			System.out.println("try");
			return "aa";
		}catch(Exception exception){
			
		}
		finally {
			System.out.println("释放锁");
		}
		return "b";
	}
	
	public static void main(String[] args) {
		System.out.println(finallyTest());
	}
}
