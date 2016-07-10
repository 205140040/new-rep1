package com.demo.deep.c21.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Accessor implements Runnable {

	public void run() {
//		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(this);
				ThreadLocalVarHolder.increment();
			}
			System.out.println("------------------------------");
//		}
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + "\tvar:" + ThreadLocalVarHolder.getValue();
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Accessor accessor = new Accessor();
		for (int i = 0; i < 3; i++) {
			executorService.execute(accessor);
		}
		executorService.shutdown();
	}
}
