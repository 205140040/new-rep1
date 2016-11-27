package com.yfairy.demo.zxing.erweima;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingErweimaDemo {

	private static final int WIDTH = 200; // 图片宽度

	private static final int HEIGHT = 200; // 图片高度

	private static final String IMGFORMAT = "png"; // 图片格式

	private static int onColor = 0xFF000000; // 前景色

	private static int offColor = 0xFFFFFFFF; // 背景色

	private static int margin = 1; // 白边大小，取值范围0~4

	private static ErrorCorrectionLevel level = ErrorCorrectionLevel.L; // 二维码容错率

	public static void main(String[] args) {
		/**
		 * Java二维码生成与解码工具Zxing使用:http://blog.csdn.net/rongbo_j/article/details/47055795
		 */
		// 生成二维码
		encodeQRCode("erweima1", "er1");

		encodeQRCode("erweima2222", "er2");

		String desktop = "C:\\Users\\jiangzi\\Desktop";

		String file1 = desktop + File.separator + "er1.png";
		String file2 = desktop + File.separator + "er2.png";

		String bk1 = desktop + File.separator + "t5.jpg";

		String file3 = desktop + File.separator + "erbk1.png";

		encodeQRCodeWithLogo("qrWithBk1", bk1, file3);
		System.out.println("解析1：" + decodeQRCode(file1));
		System.out.println("解析2：" + decodeQRCode(file2));
		System.out.println("解析3：" + decodeQRCode(file3));

	}

	/**
	 * 生成二维码
	 * 
	 * @param qrcodeContent
	 * @param fileName
	 */
	public static void encodeQRCode(String qrcodeContent, String fileName) {
		try {
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			// 编码
			QRCodeWriter writer = new QRCodeWriter();
			BitMatrix bitMatrix = writer.encode(qrcodeContent, BarcodeFormat.QR_CODE, HEIGHT, WIDTH, hints);

			// 输出二维码图片
			// MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			String desktop = "C:\\Users\\jiangzi\\Desktop";

			File outputFile = new File(desktop, fileName + ".png");
			OutputStream outputStream = new FileOutputStream(outputFile);
			MatrixToImageWriter.writeToStream(bitMatrix, IMGFORMAT, outputStream);
			outputStream.close();
			System.out.println("二维码生成成功...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成带logo的二维码图片
	 * 
	 * @param txt
	 *            //二维码内容
	 * @param logoPath
	 *            //logo绝对物理路径
	 * @param imgPath
	 *            //二维码保存绝对物理路径
	 * @throws Exception
	 */
	public static void encodeQRCodeWithLogo(String qrcodeContent, String logoPath, String qrPath) {
		try {
			// blog:http://blog.csdn.net/rongku/article/details/51872156
			Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, level);
			hints.put(EncodeHintType.MARGIN, margin); // 设置白边
			QRCodeWriter writer = new QRCodeWriter();
			BitMatrix bitMatrix = writer.encode(qrcodeContent, BarcodeFormat.QR_CODE, HEIGHT, WIDTH, hints);
			File qrcodeFile = new File(qrPath);
			mergeQrAndLogoToFile(bitMatrix, IMGFORMAT, qrcodeFile, logoPath);
			System.out.println("logo二维码生成成功...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param matrix
	 *            二维码矩阵相关
	 * @param format
	 *            二维码图片格式
	 * @param file
	 *            二维码图片文件
	 * @param logoPath
	 *            logo路径
	 * @throws IOException
	 */
	public static void mergeQrAndLogoToFile(BitMatrix matrix, String format, File file, String logoPath)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		Graphics2D gs = image.createGraphics();

		int ratioWidth = image.getWidth() * 2 / 10;
		int ratioHeight = image.getHeight() * 2 / 10;
		// 载入logo
		Image img = ImageIO.read(new File(logoPath));
		int logoWidth = img.getWidth(null) > ratioWidth ? ratioWidth : img.getWidth(null);
		int logoHeight = img.getHeight(null) > ratioHeight ? ratioHeight : img.getHeight(null);

		int x = (image.getWidth() - logoWidth) / 2;
		int y = (image.getHeight() - logoHeight) / 2;

		gs.drawImage(img, x, y, logoWidth, logoHeight, null);
		gs.setColor(Color.black);
		gs.setBackground(Color.WHITE);
		gs.dispose();
		img.flush();
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? onColor : offColor);
			}
		}
		return image;
	}

	/**
	 * 解析二维码
	 * 
	 * @param fileName
	 */
	public static String decodeQRCode(String filePath) {
		String res = null;
		try {
			// 二维码图片路径
			File imageFile = new File(filePath);
			BufferedImage image = ImageIO.read(imageFile);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			// 解码获取二维码中信息
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);
			res = result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
