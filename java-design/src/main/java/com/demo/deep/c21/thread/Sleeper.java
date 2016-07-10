package com.demo.deep.c21.thread;

public class Sleeper extends Thread{
	private int sleepTime;

	public Sleeper(String name,int sleepTime) {
		super(name);
		this.sleepTime=sleepTime;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println(getName()+"被打断:"+isInterrupted());
			return;
		}
		System.out.println(getName()+"has awakened");
	}
}
