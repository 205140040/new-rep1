package com.yfairy.demo.javacore;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SwingDemo {

	public static void main(String[] args) {
		/**
		 * 第7章图形程序设计269/720<br>
		 * abstract window toolkit AWT<br>
		 * 7.3框架定位275/720<br>
		 */
		// 所有的swing必须由事件分派进行配置
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SimpleFrame();
				// 设置关闭操作
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// 设置窗口可见
				frame.setVisible(true);
			}
		});

	}

}
