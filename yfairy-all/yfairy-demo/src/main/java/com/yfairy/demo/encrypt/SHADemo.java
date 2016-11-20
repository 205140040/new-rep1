package com.yfairy.demo.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class SHADemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// http://baike.baidu.com/link?url=tNJNpiPFZ-DRn1ZsluOH1yJOViNyTajVSsVhPqUscQqfOwcyQmksf5wlcFla1iHTWX6q1pEo9Bgn9oe3Z2G_QK
		/**
		 * SHA:安全哈希算法（Secure Hash Algorithm）主要适用于数字签名标准（Digital Signature
		 * Standard<br>
		 * DSS）里面定义的数字签名算法（Digital Signature Algorithm<br>
		 * DSA）。对于长度小于2^64位的消息，SHA1会产生一个160位的消息摘要。<br>
		 * 该算法经过加密专家多年来的发展和改进已日益完善，并被广泛使用。<br>
		 * 该算法的思想是接收一段明文，然后以一种不可逆的方式将它转换成一段（通常更小）密文，<br>
		 * 也可以简单的理解为取一串输入码（称为预映射或信息），<br>
		 * 并把它们转化为长度较短、位数固定的输出序列即散列值（也称为信息摘要或信息认证代码）的过程。<br>
		 * 散列函数值可以说是对明文的一种“指纹”或是“摘要”所以对散列值的数字签名就可以视为对此明文的数字签名。<br>
		 * <br>
		 * <br>
		 * <br>
		 * 散列算法<br>
		 * 散列是信息的提炼，通常其长度要比信息小得多，<br>
		 * 且为一个固定长度。加密性强的散列一定是不可逆的，<br>
		 * 这就意味着通过散列结果，无法推出任何部分的原始信息。<br>
		 * 任何输入信息的变化，哪怕仅一位，都将导致散列结果的明显变化，<br>
		 * 这称之为雪崩效应。散列还应该是防冲突的，<br>
		 * 即找不出具有相同散列结果的两条信息。具有这些特性的散列结果就可以用于验证信息是否被修改。<br>
		 * 单向散列函数一般用于产生消息摘要，密钥加密等，<br>
		 * 常见的有： l MD5（Message Digest Algorithm5）：是RSA数据安全公司开发的一种单向散列算法。 <br>
		 * l SHA（Secure Hash Algorithm）：可以对任意长度的数据运算生成一个160位的数值；<br>
		 * <br>
		 * <br>
		 * SHA家族:http://baike.baidu.com/link?url=qnsWSQWPPKe_QJXOPbahUGmc_ErvDczRscvTt_kTJSvYCLoj6ZKiGpNpid-NGhotz7Q6a5LkYXnFNB2V1_9vIV5-BkMtIDL5eKoxXT7eNpK#3
		 * <br>
		 * SHA1不推荐使用，推荐使用SHA2<br>
		 * SHA家族的五个算法，分别是SHA-1、SHA-224、SHA-256、SHA-384，和SHA-512，<br>
		 * 由美国国家安全局（NSA）所设计，并由美国国家标准与技术研究院（NIST）发布；是美国的政府标准。<br>
		 * 后四者有时并称为SHA-2。<br>
		 * 
		 * <br>
		 * <br>
		 * SHA-2: 维基百科，自由的百科全书 SHA-2，名称来自于安全散列算法2<br>
		 * （英语：Secure Hash Algorithm2）的缩写，一种密码杂凑函数算法标准，<br>
		 * 由美国国家安全局研发，由美国国家标准与技术研究院（NIST）在2001年发布。<br>
		 * 属于SHA算法之一，是SHA-1的后继者。其下又可再分为六个不同的算法标准，包括了<br>
		 * SHA-224, SHA-256, SHA-384, SHA-512, SHA-512/224, SHA-512/256。<br>
		 */
		String pwd = "hello123worl.";
		// 方法1和方法2只是bytes处转码成string代码不一样，但其结果一样，推荐使用第二种
		String sha2561 = messageDigestSha256(pwd);
		System.out.println("sha2561:" + sha2561);
		String sha2562 = messageDigestSha256Two(pwd);
		System.out.println("sha2561:" + sha2562);
		// 使用apache中codec中的DigestUtils中的sha256
		// String apacheSha256 = new
		// String(DigestUtils.sha256Hex(pwd.getBytes("UTF-8")), "UTF-8");
		System.out.println("apacheSha256:" + DigestUtils.sha256Hex(pwd.getBytes("UTF-8")));
		System.out.println("apacheSha256:" + DigestUtils.sha256Hex("nihao68".getBytes("UTF-8")));
	}

	public static String messageDigestSha256(String source) {
		// 可参考:http://blog.csdn.net/joyous/article/details/49898383
		String strResult = null;
		try { // 如果需要SHA-512则把SHA-256换成SHA-512
			byte[] input = source.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(input);
			byte[] resBytes = messageDigest.digest();
			// 将bytes转换成string
			StringBuffer strHexString = new StringBuffer();
			// 遍歷 byte buffer
			for (int i = 0; i < resBytes.length; i++) {
				String hex = Integer.toHexString(0xff & resBytes[i]);
				if (hex.length() == 1) {
					strHexString.append('0');
				}
				strHexString.append(hex);
			}
			// 得到返回結果
			strResult = strHexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}

	public static String messageDigestSha256Two(String source) {
		// 可参考:http://blog.csdn.net/joyous/article/details/49898383
		String strResult = null;
		try { // 如果需要SHA-512则把SHA-256换成SHA-512
			byte[] input = source.getBytes("UTF-8");
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(input);
			byte[] resBytes = messageDigest.digest();
			// 将bytes转换成string

			StringBuffer sb = new StringBuffer();
			for (byte b : resBytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					sb.append(0);
				}
				sb.append(Integer.toHexString(bt));
			}
			strResult = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
	}

}
