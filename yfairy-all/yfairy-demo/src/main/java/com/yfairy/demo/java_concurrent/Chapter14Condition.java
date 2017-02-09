package com.yfairy.demo.java_concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chapter14Condition {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 第14章：构建自定义的同步工具252/308<br>
		 * Condition:http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Condition.html<br>
		 * 可参考:http://blog.csdn.net/ghsau/article/details/7481142
		 */
		Lock lock = new ReentrantLock();

		Condition condition = lock.newCondition();
		condition.await(); // 等待 类似 object.wait();

		condition.signal(); // 唤醒 类似 object.notify();

		// condition.signalAll(); // 唤醒所有 类似 object.notifyAll();

		Object object = new Object();
		object.wait();
		object.notify();
		// object.notifyAll();
		System.out.println("hello");

		// AbstractQueuedSynchronizer

	}

	static class SyncQueue<V> {

		private V[] datas;

		private int head;

		private int tail;

		private int count;

		public SyncQueue(int size) {
			super();
			this.datas = (V[]) new Object[size];
		}

		public synchronized void put(V v) throws InterruptedException {
			datas[tail] = v;
			if (++tail == datas.length) {
				tail = 0;
			}
			++count;
		}

		public synchronized V take() throws InterruptedException {
			V v = datas[head];
			datas[head] = null;
			if (++head == datas.length) {
				head = 0;
			}
			--count;
			return v;
		}

		public synchronized boolean isFull() {
			return count == datas.length;
		}

		public synchronized boolean isEmpty() {
			return count == 0;
		}

	}

	static class WaitSyncQueue<V> extends SyncQueue<V> {

		public WaitSyncQueue(int size) {
			super(size);
		}

		@Override
		public synchronized void put(V v) throws InterruptedException {
			while (isFull()) {
				wait(); // 当队列满时通过 wait，实现条件等待，wait会释放锁，直到条件满足，再次运行
			}
			super.put(v);
			notifyAll(); // 唤醒
		}

		@Override
		public synchronized V take() throws InterruptedException {
			while (isEmpty()) {
				wait();
			}
			V v = super.take();
			notifyAll();
			return v;
		}

	}
}
