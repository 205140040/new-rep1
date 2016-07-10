package com.demo.deep.c21.thread;

public class Joinner extends Thread{
	private Sleeper sleeper;

	public Joinner(String name,Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleeper.join();//当前线程中加入另外一个线程
		} catch (InterruptedException e) {
			System.out.println("打断");
		} 
		System.out.println(getName()+"加入完成");
	}
	
}
