package com.yfairy.demo.java_concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * CountDownLatch闭锁<br>
		 * http://www.itzhai.com/the-introduction-and-use-of-a-countdownlatch.html<br>
		 * 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
		 * 
		 * 用给定的计数 初始化 CountDownLatch。由于调用了 countDown() 方法，所以在当前计数到达零之前，await
		 * 方法会一直受阻塞。 之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。
		 * 这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。<br>
		 * await
		 * 
		 * public boolean await(long timeout, TimeUnit unit) throws
		 * InterruptedException
		 * 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。如果当前计数为零，则此方法立刻返回 true 值。<br>
		 * 
		 * countDown
		 * 
		 * public void countDown()
		 * 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。如果当前计数大于零，则将计数减少。如果新的计数为零，出于线程调度目的，将重新启用所有的等待线程。
		 * 如果当前计数等于零，则不发生任何操作。<br>
		 */
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						// 等待
						start.await();
						System.out.println(Thread.currentThread() + "\t" + "run...");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						end.countDown(); // 减1
					}
				}
			};
			t.start();
		}
		System.out.println("开始...");
		start.countDown();
		end.await();
		System.out.println("结束...");
	}

}
