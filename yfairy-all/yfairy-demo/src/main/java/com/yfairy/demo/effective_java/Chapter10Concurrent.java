package com.yfairy.demo.effective_java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chapter10Concurrent {

	public static void main(String[] args) {
		/**
		 * 第10章:并发229(242/303)<br>
		 * 第66条同步访问共享的数据<br>
		 * 第67条避免过度同步<br>
		 * 第68条：Executor和task优先于线程<br>
		 * Executors.newCachedThreadPool();比较适合较少的线程，<br>
		 * 它每次都会启动新线程,不适合较多的线程启动<br>
		 * Executors.newFixedThreadPool(nThreads) <br>
		 * 会启动一个固定大小的线程池，会重复利用池中的线程，<br>
		 * 不会一直创建线程<br>
		 * 73条避免使用线程组<br>
		 */
		ExecutorService es = Executors.newCachedThreadPool();
	}

}
