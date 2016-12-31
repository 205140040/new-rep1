package com.yfairy.demo.javacore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerPrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("----------------------------");
		Date now=new Date();
		System.out.println(Thread.currentThread().getName());
		System.out.println(now.toLocaleString());
		System.out.println("----------------------------");
	}

	public static void main(String[] args) {
		/**
		 * 6.3接口与回调243/720<br>
		 * 接口回调，把接口传递给一个方法，然后在该方法中调用该接口的方法
		 */
		ActionListener actionListener=new TimerPrinter();
		javax.swing.Timer timer=new javax.swing.Timer(3000, actionListener);
		timer.start();
	}
}
