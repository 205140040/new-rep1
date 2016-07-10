package com.demo.deep.c21.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) throws Exception {
		/**
		 * callable接口，多线程带有返回值
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 6; i++) {
			// submit方法启动,submit()会产生Future对象，可以用Future.isDone查询Future是否完成，
			results.add(executorService.submit(new Call1(i)));
		}
		for (Future<String> future : results) {
			System.out.println("是否完成:" + future.isDone());
			if (future.isDone()) {
				System.out.println(future.get());
			}
		}
		executorService.shutdown();
	}

}
