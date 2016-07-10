package com.demo.deep.c21.thread;

import java.util.concurrent.TimeUnit;

/**
 * 实现runnable接口，定义一个任务
 */
public class Runnable1 implements Runnable {

	private int priority;

	public Runnable1() {
		super();
	}

	public Runnable1(int priority) {
		super();
		this.priority = priority;
	}

	public void run() {
		//设置优先级
		Thread.currentThread().setPriority(priority);
		System.out.println("线程名称:" + Thread.currentThread().getName() + "\t优先级:" + Thread.currentThread().getPriority());
		// Thread.yield(); 礼让,当调用yield时，是建议其他线程可运行
		try {
			// 休眠 ==Thread.sleep(millis);
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程名称:" + Thread.currentThread().getName() + "在运行,id:" + Thread.currentThread().getId());
	}

}
