package com.yfairy.demo.java_concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 扩展线程池执行器ThreadPoolExecutor<br>
 * 重写beforeExecute,afterExecute,terminated
 * 
 * @author jiangzi
 *
 */
public class TimeThreadPool extends ThreadPoolExecutor {

	private final ThreadLocal<Long> startTime = new ThreadLocal<>();

	private final AtomicLong numTasks = new AtomicLong();

	private final AtomicLong totalTime = new AtomicLong();

	public TimeThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		startTime.set(System.nanoTime());
		System.out.println("startTime:" + startTime.get());
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		long endTime = System.nanoTime();
		System.out.println("endTime:" + endTime);
		long taskTime = endTime - startTime.get();
		totalTime.addAndGet(taskTime); // 总时间增加
		numTasks.incrementAndGet(); // 任务数量自增
	}

	@Override
	protected void terminated() {
		super.terminated();
		System.out.println("任务数量:" + numTasks.get() + "\t总时间:" + totalTime.get());

		System.out.println("平均时间:" + (totalTime.get() / numTasks.get()));
	}

}
