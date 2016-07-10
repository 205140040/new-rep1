package com.demo.deep.c21.thread;

public class ThreadLocalVarHolder {
	/**
	 * 线程本地存储
	 * ,防止任务在共同资源上产生冲突的第二个方式是根除对变量的共享
	 * ，线程本地存储可以为使用相同变量的每个线程都创建不同的存储
	 * ThreadLocal对象通常当做静态域存储，使用ThreadLocal的get和set方法访问该对象
	 */
	private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		protected Integer initialValue() {return 1;};
	};
	
	public static void increment(){
		value.set(value.get()+1);
	}
	
	public static int getValue(){
		return value.get();
	}
}
