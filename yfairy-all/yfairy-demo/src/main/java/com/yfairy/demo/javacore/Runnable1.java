package com.yfairy.demo.javacore;

import java.util.Date;

public class Runnable1 implements Runnable {

	@Override
	public void run() {
		System.out.println("---------date:"+new Date().toLocaleString());
		System.out.println(this.getClass().getName());
		System.out.println("Thread:Name:"+Thread.currentThread().getName()+"\tID:"+Thread.currentThread().getId());
	}

}
