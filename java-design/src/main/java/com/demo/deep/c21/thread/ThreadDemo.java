package com.demo.deep.c21.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {

	public static void main(String[] args) {
		/**
		 * 启动线程需要使用thread类
		 */
		// Runnable1 r1 = new Runnable1();
		/*
		 * for (int i = 0; i < 5; i++) { Thread t1 = new Thread(r1); t1.start();
		 * }
		 */

		/**
		 * 使用executor管理Thread对象
		 * ,newCachedThreadPool();在程序执行过程中会创建所需数量相同的线程，在他回收旧线程时会停止创建新的线程，默认首选
		 * newFixedThreadPool使用有效的线程集执行任务,
		 * newSingleThreadExecutor==newFixedThreadPool（1），如果使用单个线程池运行多个任务，
		 * 他的任务会排队，上一个运行完才进行下一个
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 6; i++) {
			if ((i % 2) == 0) {
				executorService.execute(new Runnable1(Thread.MAX_PRIORITY));
			} else {
				executorService.execute(new Runnable1(Thread.MIN_PRIORITY));
			}
		}
		executorService.shutdown();

	}

}
