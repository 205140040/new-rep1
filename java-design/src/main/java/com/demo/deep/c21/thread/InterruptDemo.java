package com.demo.deep.c21.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InterruptDemo extends Thread {

	private volatile boolean canel = false;

	public void canceled() {
		canel = true;
	}

	@Override
	public void run() {
		try {
				System.out.println(this);
				TimeUnit.MILLISECONDS.sleep(1000);
		} catch (Exception e) {
			System.out.println("异常:" + e.getMessage());
			System.out.println(this + ",中断...........");
		}

	}

	@Override
	public String toString() {
		return "id:" + currentThread().getId() + "\tname:" + currentThread().getName();
	}

	public static void main(String[] args) {
		/**
		 * interrupt打断任务
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<?>> futures = new ArrayList<Future<?>>();
		for (int i = 0; i < 3; i++) {
			futures.add(executorService.submit(new InterruptDemo()));
		}
		executorService.shutdownNow(); //中断所有的任务
//		for (Future<?> future : futures) {
//			future.cancel(true); // 打断任务
//		}
		executorService.shutdown();
	}
}
