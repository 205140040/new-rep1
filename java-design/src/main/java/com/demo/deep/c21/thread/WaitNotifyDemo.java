package com.demo.deep.c21.thread;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyDemo {

	private List<String> menuList = new ArrayList<String>();

	public static void main(String[] args) {
		/**
		 * wait(timeout);在毫秒时间类等待，与sleep类似，但是sleeep不释放锁，wait释放锁
		 * ,可以通过notify，或notifyall，或者等待时间到期来唤醒任务,\
		 * 如果调用某个对象的wait()方法，当前线程必须拥有这个对象的monitor（即锁），
		 * 因此调用wait()方法必须在同步块或者同步方法中进行（synchronized块或者synchronized方法）。
		 */
		// http://www.cnblogs.com/dolphin0520/p/3920385.html
		WaitNotifyDemo w = new WaitNotifyDemo();
		product p1 = w.new product();
		consumer c1 = w.new consumer();
		p1.start();
		c1.start();
		product p2 = w.new product();
		p2.start();
	}

	class product extends Thread {

		@Override
		public void run() {
			synchronized (menuList) {
				while (true) {
					while (menuList.size() > 0) {
						System.out.println("生产者等待....");
						try {
							menuList.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("生产者生产:" + currentThread().getName());
					menuList.add("cai1");
					menuList.notify();
				}
			}
		}
	}

	class consumer extends Thread {

		@Override
		public void run() {
			synchronized (menuList) {
				while (true) {
					while (menuList.size() < 1) {
						System.out.println("菜单为空....消费者等待.....");
						try {
							menuList.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(currentThread().getName() + "消费:");
					menuList.remove("cai1");
					menuList.notify(); // 唤醒生产者任务
				}

			}
		}
	}
}
