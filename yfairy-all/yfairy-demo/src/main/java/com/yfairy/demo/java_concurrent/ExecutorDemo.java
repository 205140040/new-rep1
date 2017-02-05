package com.yfairy.demo.java_concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 6.2Executor(执行器)框架<br>
		 * 创建线程需要时间，资源等消耗，如果新建很多线程，处理器太忙，且线程切换开销也大，使用Executor框架<br>
		 * Executors.newFixedThreadPool(100);创建一个固定长度的线程池，每次都新建线程，直到达到长度，<br>
		 * Executors.newCachedThreadPool();创建缓存线程池，多余时会回收，不够时新增<br>
		 * Executors.newSingleThreadExecutor();创建单个任务执行器
		 */
		// newFixedThreadPool fixed固定的，固定大小的线程池
		// Executor exec1=Executors.newFixedThreadPool(100); //
		ExecutorService exec1 = Executors.newFixedThreadPool(100); //
		// Executor e2 = Executors.newScheduledThreadPool(50);
		// ScheduledThreadPoolExecutor e2 = Executors.newsc

		for (int i = 0; i < 200; i++) {
			System.out.println(i + "");
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("\t" + Thread.currentThread());
				}
			};
			exec1.execute(runnable);

			Runnable r2 = new Runnable() {

				@Override
				public void run() {
					System.out.println("r2\t" + Thread.currentThread());
				}
			};
			// e2.execute(r2);
		}
		exec1.shutdown(); // 运行完关闭Executor

		// Callable,创建具有返回值的线程
		// Callable使用:http://wenku.baidu.com/link?url=hzLqUAs8vWdkoOURyiFEJplGxQ_QlOulkVM67lWW-gFZDOmmhYJw8i-vg072KCrE1WzYw34ZFuWDYd0mRsAVKEZ5PBb-y1kfFR9vFzvxkh7
		Callable<Integer> c = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i <= 100; i++) {
					sum += i;
				}
				return sum;
			}

		};
		// 通过FutureTask，和Thread启动
		FutureTask<Integer> futureTask = new FutureTask<>(c);
		Thread t = new Thread(futureTask);
		t.start();
		// Futureget()等待直到返回结果
		System.out.println("futureTask:" + futureTask.get());

		// 通过执行器运行Callable
		ExecutorService futureExe = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 20; i++) {
			Callable<Integer> callable = new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println(Thread.currentThread());
					int sum = 0;
					for (int i = 1; i <= 100; i++) {
						sum += i;
					}
					return sum;
				}

			};
			// 通过执行器submit方法执行Callable，获得Future结果
			Future<Integer> future = futureExe.submit(callable);
			System.out.println("CallableResult:" + future.get());
		}
		futureExe.shutdown(); // 关闭

		// 设置Future超时不在运行,Future.get(long timeout, TimeUnit unit)
		// 超时抛出异常,Exception in thread "main"
		// java.util.concurrent.TimeoutException
		Callable<Integer> c2 = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Thread.sleep(3000);
				return null;
			}

		};
		FutureTask<Integer> futureTask2 = new FutureTask<>(c2);
		Thread t2 = new Thread(futureTask2);
		t2.start();
		System.out.println(futureTask2.get(1, TimeUnit.SECONDS));
	}

}
