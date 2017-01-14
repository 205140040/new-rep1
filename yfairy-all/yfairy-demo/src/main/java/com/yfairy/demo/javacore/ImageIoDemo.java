package com.yfairy.demo.javacore;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageIoDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * ImageIO<br>
		 * 可参考:http://wenku.baidu.com/view/ddbb1d7101f69e31433294b8.html如何使用ImageIo<br>
		 * 这个是imageUtil：http://blog.csdn.net/oh_mourinho/article/details/7979003<br>
		 */
		// BufferedImage的本质是一个带有可访问数据缓存的Image。直接操作BufferedImage会更高效

		// 读取图像
		String desktop = "C:\\Users\\jiangzi\\Desktop";
		File img1 = new File(desktop, "t5.jpg");
		BufferedImage bufferedImage = ImageIO.read(img1);
		// 输出图像write(RenderedImage im, String formatName, File output)
		// RenderedImage 即BufferedImage
		ImageIO.write(bufferedImage, "png", new File(desktop, "t5cp.png"));

		// 画图
		int width = 80;
		int height = 30;
		// 创建图像
		BufferedImage bi2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi2.createGraphics(); // 创建画笔
		g2d.setColor(new Color(204, 255, 204));
		// 画背景
		g2d.fillRect(0, 0, width, height);
		// 画string
		g2d.setColor(Color.GREEN);
		g2d.drawString("hello", 10, 20);
		g2d.setColor(Color.PINK);
		g2d.drawString("你好", 40, 20);
		// 输出图像
		ImageIO.write(bi2, "png", new FileOutputStream(new File(desktop, "bi2.png")));

		Logger.getGlobal().info("success...");
	}

}
