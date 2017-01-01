package com.yfairy.demo.javacore;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class SimpleComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 绘制类容
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.drawString("hello world", 75, 100);
		// 处理2D图形
		Graphics2D g2d = (Graphics2D) g;
		// 画矩形
		Rectangle2D rectangle2d = new Rectangle2D.Double(100, 100, 200, 150);
		g2d.draw(rectangle2d);
		// 椭圆
		Ellipse2D ellipse2d = new Ellipse2D.Double();
		ellipse2d.setFrame(rectangle2d);
		g2d.draw(ellipse2d);
	}

	/**
	 * 组件大小
	 */
	@Override
	public Dimension getPreferredSize() {
		// 获取屏幕的宽高
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = dimension.width / 2; // 设置窗口为原始屏幕的二分之一
		int height = dimension.height / 2;
		return new Dimension(width, height);
	}

}
