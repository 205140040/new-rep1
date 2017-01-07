package com.yfairy.demo.javacore;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * 第14章：多线程636/720<br>
		 * 14.5.4条件对象663/720<br>
		 */
		// 创建多线程1.实现runnable,2继承Thread
		Runnable run1 = new Runnable1();
		Thread t1 = new Thread(run1);
		t1.start();

		Thread t2 = new Thread1();
		t2.start();
		System.out.println("--------------");
		// 14.5同步,660/720
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread2();
			t.start();
		}

		Thread.sleep(2000);
		System.out.println(Thread2.count);
	}

}
