package com.demo.deep.c21.thread;

public class ThreadLocalVarHolder {
	/**
	 * 线程本地存储 ,防止任务在共同资源上产生冲突的第二个方式是根除对变量的共享 ，线程本地存储可以为使用相同变量的每个线程都创建不同的存储
	 * ThreadLocal对象通常当做静态域存储，使用ThreadLocal的get和set方法访问该对象
	 */
	/**
	 * void set(Object value) //设置当前线程的线程局部变量的值。
	 * 
	 * public Object get() //该方法返回当前线程所对应的线程局部变量。
	 * 
	 * public void remove() //将当前线程局部变量的值删除，目的是为了减少内存的占用， 该方法是JDK
	 * 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须//的操作，
	 * 但它可以加快内存回收的速度。
	 * 
	 * protected Object initialValue() //返回该线程局部变量的初始值，该方法是一个protected的方法，
	 * 显然是为了让子类覆盖而设计的。这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。
	 * ThreadLocal中的缺省//实现直接返回一个null。
	 */
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 1;
		};
	};

	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int getValue() {
		return value.get();
	}
}
