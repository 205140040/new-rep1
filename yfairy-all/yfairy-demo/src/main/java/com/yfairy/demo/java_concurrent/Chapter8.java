package com.yfairy.demo.java_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Chapter8 {

	public static void main(String[] args) {
		/**
		 * 第8章：线程池的使用152/308<br>
		 * 8.1 同类型相互独立的任务，线程池才能发挥比较好，如果把不同类型，<br>
		 * 不同时长的任务放到线程池中，反而不好<br>
		 * 如果一个执行器，执行A任务，a任务中使用该执行器，执行b，c任务，<br>
		 * 即用一个线程池执行器，执行多个不同时长任务，且执行器需要等待b，c任务的结果<br>
		 * 有可能造成死锁.<br>
		 * 8.2线程池的大小<br>
		 * 8.3配置ThreadPoolExecutor<br>
		 */
		ExecutorService es = new TimeThreadPool(5, 5, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 10; i++) {
			es.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread());
				}
			});
		}
		es.shutdown();
	}

}
