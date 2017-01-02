package com.yfairy.demo.javacore;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SwingDemo {

	public static void main(String[] args) {
		/**
		 * 第7章图形程序设计269/720<br>
		 * abstract window toolkit AWT<br>
		 * 7.3框架定位275/720<br>
		 * 7.6使用颜色293/720<br>
		 * 第8章：事件处理307/720<br>
		 * 第9章：swing用户界面组件338/720<br>
		 */

		// 获取系统图形环境支持的字体
		// String[] fonts =
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		// for (String font : fonts) {
		// System.out.println(font);
		// }

		// 所有的swing必须由事件分派进行配置
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// 获取屏幕的宽高
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension dimension = toolkit.getScreenSize();
				int width = dimension.width / 2; // 设置窗口为原始屏幕的二分之一
				int height = dimension.height / 2;

				JFrame frame = new SimpleFrame(width, height);
				// 设置关闭操作
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// 设置窗口可见
				frame.setVisible(true);
				// 设置标题
				frame.setTitle("应用1");

				// frame.setLocationByPlatform(true);
				Image image = new ImageIcon("icon.gif").getImage();
				frame.setIconImage(image);

				// 设置定位
				frame.setLocation(width / 2, 200);
				
				//添加frame监听器
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowOpened(WindowEvent e) {
						System.out.println("窗口打开了");
						super.windowOpened(e);
					}
					
				});
			}
		});

	}

}
