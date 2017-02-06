package com.yfairy.demo.java_concurrent;

public class Chapter10 {

	public static void main(String[] args) {
		/**
		 * 第10章:避免活跃性危险183/308<br>
		 * 
		 */
		// A等待B的锁,B等待A的锁,容易发生死锁
		LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock();
		for (int i = 0; i < 100; i++) {
			Thread t3 = new Thread3(leftRightDeadLock);
			t3.start();
		}
	}

	static class Thread3 extends Thread {
		private LeftRightDeadLock leftRightDeadLock;

		public Thread3(LeftRightDeadLock leftRightDeadLock) {
			super();
			this.leftRightDeadLock = leftRightDeadLock;
		}

		@Override
		public void run() {
			leftRightDeadLock.leftRight();
			System.out.println();
			leftRightDeadLock.rightLeft();
		}

	}

	static class LeftRightDeadLock {
		private Object left = new Object();

		private Object right = new Object();

		public void leftRight() {
			synchronized (left) {
				synchronized (right) {
					System.out.println("leftRight");
				}
			}
		}

		public void rightLeft() {
			synchronized (right) {
				synchronized (left) {
					System.out.println("rightLeft");
				}
			}
		}

	}

}
