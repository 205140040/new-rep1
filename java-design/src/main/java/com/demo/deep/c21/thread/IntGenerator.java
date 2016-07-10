package com.demo.deep.c21.thread;

public abstract class IntGenerator {
	
	/**
	 * volatile当一个字段共享时，声明为volatile的，可以在多个线程中可视，不需要同步，它是原子性的
	 */
	private volatile boolean canceled = false;

	public abstract int next();

	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}
}
