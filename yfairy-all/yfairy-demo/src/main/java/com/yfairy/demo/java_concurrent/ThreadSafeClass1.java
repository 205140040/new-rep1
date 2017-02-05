package com.yfairy.demo.java_concurrent;

/**
 * synchronized同步锁构建线程安全类
 * 
 * @author Yosemite
 *
 */

public class ThreadSafeClass1 {
	private int num;

	public synchronized int getNum() {
		return num;
	}

	public synchronized void setNum(int num) {
		this.num = num;
	}

}
