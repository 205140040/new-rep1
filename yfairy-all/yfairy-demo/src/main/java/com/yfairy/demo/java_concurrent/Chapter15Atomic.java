package com.yfairy.demo.java_concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Chapter15Atomic {

	public static void main(String[] args) {
		/**
		 * 第15章：原子变量与非阻塞同步机制275/308<br>
		 * 比较并交换CAS:,查看期望值是否和原始值相同，相同则交换值，否则重新尝试<br>
		 * 通过CAS，代替锁，有更好的效果
		 */
		AtomicInteger ato = new AtomicInteger();
		ato.incrementAndGet();
		System.out.println(ato.get());
	}

	static class CASClass {
		private int value;

		public synchronized int getValue() {
			return value;
		}

		public synchronized int compareAndSwap(int exp, int newVal) {
			int old = value;
			if (exp == old) {
				value = newVal;
			}
			return old;
		}

		public synchronized boolean compareAndSet(int exp, int newVal) {
			return (exp == compareAndSwap(exp, newVal));
		}

	}

}
