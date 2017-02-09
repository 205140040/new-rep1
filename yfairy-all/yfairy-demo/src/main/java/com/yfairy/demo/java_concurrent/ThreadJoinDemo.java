package com.yfairy.demo.java_concurrent;

public class ThreadJoinDemo {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * thread.join();<br>
		 * Java
		 * Thread.join()详解:http://www.open-open.com/lib/view/open1371741636171.html<br>
		 * javadoc:http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html(用谷歌翻译)<br>
		 */
		Thread thread = new Thread() {

		};
		// Waits for this thread to die.
		// An invocation of this method behaves in exactly the same way as the
		// invocation
		// 等待这个线程死亡。此方法的调用行为正确
		thread.join();
	}
}
