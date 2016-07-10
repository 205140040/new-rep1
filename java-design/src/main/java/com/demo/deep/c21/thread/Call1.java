package com.demo.deep.c21.thread;

import java.util.concurrent.Callable;
/**
 * 线程中产生返回值，runnable不返回任何值，实现callable接口，可以在任务完成时返回一个值
 */
public class Call1 implements Callable<String>{
	private int id;
	
	

	public Call1(int id) {
		super();
		this.id = id;
	}



	public String call() throws Exception {
		return "TaskWithResult id:"+id;
	}

}
