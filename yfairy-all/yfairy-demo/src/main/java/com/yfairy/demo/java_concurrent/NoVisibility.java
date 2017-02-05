package com.yfairy.demo.java_concurrent;

public class NoVisibility {

	private static boolean ready;

	/**
	 * volatile实现变量共享，一般只推荐用于Boolean值,volatile变量不足够确保递增++的原子性<br>
	 * 加锁可以确保可见性和原子性，volatile只能确保可见性
	 */
	private static volatile boolean ready2;

	private static int number;

	private static class ReaderThread extends Thread {
		@Override
		public void run() {
			while (!ready2) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static boolean isReady2() {
		return ready2;
	}

	public static void setReady2(boolean ready2) {
		NoVisibility.ready2 = ready2;
	}

	public static void main(String[] args) {
		new ReaderThread().start();
		number = 66;
		ready = true;
		ready2 = true;
	}

}
