package com.yfairy.demo.javacore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;

import javax.swing.ImageIcon;
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

		// 处理2D图形
		Graphics2D g2d = (Graphics2D) g;

		// 构造字体
		Font font = new Font("SansSerif", Font.BOLD, 30);
		g2d.setFont(font);

		// 设置颜色
		g2d.setPaint(Color.PINK);
		g2d.drawString("hello world", 75, 100);

		// 画矩形
		Rectangle2D rectangle2d = new Rectangle2D.Double(100, 100, 200, 150);
		g2d.setPaint(Color.BLACK);

		g2d.draw(rectangle2d);
		// 椭圆
		Ellipse2D ellipse2d = new Ellipse2D.Double();
		ellipse2d.setFrame(rectangle2d);
		g2d.draw(ellipse2d);

		g2d.setPaint(Color.PINK);
		// 填充颜色
		// 设置颜色
		Color color = new Color(0, 128, 128);
		g2d.setPaint(color);
		g2d.fill(rectangle2d);

		// 画图
		String imgPath = "C:\\Users\\jiangzi\\Desktop" + File.separator + "t5.jpg";
		Image image = new ImageIcon(imgPath).getImage();
		g2d.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
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
