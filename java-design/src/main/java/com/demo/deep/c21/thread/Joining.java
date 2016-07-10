package com.demo.deep.c21.thread;

public class Joining {

	public static void main(String[] args) {
		Sleeper s1=new Sleeper("sleeper1", 1500);
		Sleeper s2=new Sleeper("sleeper2", 1500);
		Joinner j1=new Joinner("joinner1", s1);
		Joinner j2=new Joinner("joinner2", s2);
		s2.interrupt(); //打断线程运行
	}

}
