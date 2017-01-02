package com.yfairy.demo.javacore;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class Applet1 extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		/**
		 * 调用run as java applet启动
		 */
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JLabel label = new JLabel("hello JApplet");
				JApplet applet = new Applet1();
				applet.add(label);

			}
		});
	}
}
