package com.yfairy.demo.java_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockQueue阻塞队列，当添加时如果当队列满了将阻塞，移除时当队列为空将阻塞 该队列为并发队列
 * 
 * @author Yosemite
 *
 */
public class BlockQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(80);
		Thread p1 = new Producter(blockingQueue);
		Thread p2 = new Producter(blockingQueue);
		Thread c1 = new Consumer(blockingQueue);
		Thread c2 = new Consumer(blockingQueue);
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}

	static class Producter extends Thread {

		private BlockingQueue<String> blockingQueue;

		public Producter(BlockingQueue<String> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 100; i++) {
				boolean b = blockingQueue.offer(Integer.toString(i));
				System.out.println(Thread.currentThread() + "\t" + i + "\t" + b);
			}
			// 没有空间时阻塞添加
			System.out.println(blockingQueue.offer("101"));
		}
	}

	static class Consumer extends Thread {
		private BlockingQueue<String> blockingQueue;

		public Consumer(BlockingQueue<String> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 108; i++) {
				try {
					System.out.println(Thread.currentThread() + "\t" + blockingQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
