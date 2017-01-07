package com.yfairy.demo.javacore;

import java.util.Date;

public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("---------date:" + new Date().toLocaleString());
		System.out.println(this.getClass().getName());
		System.out
				.println("Thread:Name:" + Thread.currentThread().getName() + "\tID:" + Thread.currentThread().getId());
		Thread current = Thread.currentThread();
		current.interrupt(); // 中断当前线程
		if (current.isInterrupted()) {
			System.out.println("isInterrupted方法测试线程是否被中断");
			System.out.println("Thread:Name:" + Thread.currentThread().getName() + "\t被中断");
		}
		System.out.println("中断之后的代码");
	}

}
