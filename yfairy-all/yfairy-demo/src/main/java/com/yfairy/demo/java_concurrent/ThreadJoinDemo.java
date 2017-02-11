package com.yfairy.demo.java_concurrent;

public class ThreadJoinDemo {
	public static void main(String[] args) throws Exception {
		/**
		 * thread.join();<br>
		 * Java
		 * Thread.join()详解:http://www.open-open.com/lib/view/open1371741636171.html<br>
		 * javadoc:http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html(用谷歌翻译)<br>
		 */

		// Waits for this thread to die.
		// An invocation of this method behaves in exactly the same way as the
		// invocation
		// 等待这个线程死亡。此方法的调用行为正确
		// Thread.join(); // 加入一个线程运行，直到该线程运行完毕

		Thread tb = new ThreadB("ThreadB");
		Thread ta = new ThreadA(tb, "ThreadA");

		ta.start();
		tb.start();

	}

	static class ThreadA extends Thread {

		private Thread tb;

		public ThreadA(Thread tb, String name) {
			super(name);
			this.tb = tb;
		}

		@Override
		public void run() {

			System.out.println(Thread.currentThread() + "\t开始");
			try {
				// 加入一个线程运行，直到该线程运行完毕
				tb.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "运行...");
			System.out.println(Thread.currentThread() + "\t运行完毕");
		}
	}

	static class ThreadB extends Thread {

		public ThreadB(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread() + "\t开始");
			try {
				long st = 10000;
				Thread.sleep(st);
				System.out.println(Thread.currentThread() + "休眠" + (st / 1000) + "秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "运行...");
			System.out.println(Thread.currentThread() + "\t运行完毕");
		}
	}
}
