package com.yfairy.demo.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Demo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * (百度百科) MD5:Message Digest Algorithm MD5（中文名为消息摘要算法第五版）
		 * 为计算机安全领域广泛使用的一种散列函数，用以提供消息的完整性保护。<br>
		 * MD5算法具有以下特点： 1、压缩性：任意长度的数据，算出的MD5值长度都是固定的。<br>
		 * 2、容易计算：从原数据计算出MD5值很容易。<br>
		 * 3、抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。<br>
		 * 4、强抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。<br>
		 * MD5的作用是让大容量信息在用数字签名软件签署私人密钥前被"压缩"成一种保密的格式<br>
		 * （就是把一个任意长度的字节串变换成一定长的十六进制数字串）。<br>
		 * 除了MD5以外，其中比较有名的还有sha-1、RIPEMD以及Haval等。<br>
		 * (http://baike.baidu.com/link?url=ju0AP_PT_XiogW_FjWx2h0o4-U-7MEKH96-zDfHpyRBac5GrIiTuBPcU4lMUhburzbIjFRNZdqgAybutUEPgO_)<br>
		 * 为什么现在网上有很多软件可以破解MD5，但MD5还是很流行？:https://www.zhihu.com/question/22311285<br>
		 * <br>
		 * MD5应用: 1.一致性验证: MD5的
		 * md5典型应用是对一段信息（Message）产生信息摘要（Message-Digest），以防止被篡改。<br>
		 * 比如，在Unix下有很多软件在下载的时候都有一个文件名相同，文件扩展名为.md5的文件，
		 * 在这个文件中通常只有一行文本，用以比较文件是否被改动过<br>
		 * 具体来说文件的MD5值就像是这个文件的“数字指纹”。<br>
		 * 每个文件的MD5值是不同的，如果任何人对文件做了任何改动，<br>
		 * 其MD5值也就是对应的“数字指纹”就会发生变化。<br>
		 * 比如下载服务器针对一个文件预先提供一个MD5值，用户下载完该文件后，<br>
		 * 用我这个算法重新计算下载文件的MD5值，通过比较这两个值是否相同，<br>
		 * 就能判断下载的文件是否出错，或者说下载的文件是否被篡改了。<br>
		 * <br>
		 * 2.安全访问认证<br>
		 * MD5还广泛用于操作系统的登陆认证上，如Unix、各类BSD系统登录密码、数字签名等诸多方面。<br>
		 * 如在Unix系统中用户的密码是以MD5（或其它类似的算法）经Hash运算后存储在文件系统中。<br>
		 * 当用户登录的时候，系统把用户输入的密码进行MD5Hash运算，然后再去和保存在文件系统中的MD5值进行比较，<br>
		 * 进而确定输入的密码是否正确。通过这样的步骤，<br>
		 * 系统在并不知道用户密码的明码的情况下就可以确定用户登录系统的合法性。<br>
		 * 这可以避免用户的密码被具有系统管理员权限的用户知道。<br>
		 * MD5将任意长度的“字节串”映射为一个128bit的大整数，并且是通过该128bit反推原始字符串是困难的，<br>
		 * 换句话说就是，即使你看到源程序和算法描述，也无法将一个MD5的值变换回原始的字符串，<br>
		 * 从数学原理上说，是因为原始的字符串有无穷多个，这有点象不存在反函数的数学函数。<br>
		 * 所以，要遇到了md5密码的问题，比较好的办法是：你可以用这个系统中的md5（）函数重新设一个密码，<br>
		 * 如admin，把生成的一串密码的Hash值覆盖原来的Hash值就行了。<br>
		 * 正是因为这个原因，现在被黑客使用最多的一种破译密码的方法就是一种被称为"跑字典"的方法。<br>
		 * 有两种方法得到字典，一种是日常搜集的用做密码的字符串表，<br>
		 * 另一种是用排列组合方法生成的，先用MD5程序计算出这些字典项的MD5值，<br>
		 * 然后再用目标的MD5值在这个字典中检索。我们假设密码的最大长度为8位字节（8
		 * Bytes），同时密码只能是字母和数字，共26+26+10=62个字节，<br>
		 * 排列组合出的字典的项数则是P（62,1）+P（62,2）….+P（62,8），<br>
		 * 那也已经是一个很天文的数字了，存储这个字典就需要TB级的磁盘阵列，<br>
		 * 而且这种方法还有一个前提，就是能获得目标账户的密码MD5值的情况下才可以。<br>
		 * 这种加密技术被广泛的应用于Unix系统中，<br>
		 * 这也是为什么Unix系统比一般操作系统更为坚固一个重要原因。<br>
		 * <br>
		 * MessageDigest的功能及用法:http://blog.csdn.net/ma1kong/article/details/2662997
		 * 为什么要获取32位的md5码:(https://www.zhihu.com/question/19790526)
		 * MD5本质是hash函数，并不是用来加密的，而是散列<br>
		 * ，标准的md5函数是生成128位的<br>
		 * 但是由于128位的标准存储起来也较为麻烦，而且事实上这么长实际也没必要这么强大，
		 * 截取32位在密码上用的比较多，现在有很多在线破解平台，而且较为容易识别，
		 * 于是为了安全性，各个应用程序采用了不同的手段，常见的比如截取8-24位，也就16位hash，
		 * 也有一些人采用32位再加一个8位密文（各有不同的方法），各种不同的方法嘛。。
		 * 
		 */
		// java生成32位MD5码
		String pwd = "hello123worl.";
		String javaMd532 = javaMd5Hex2(pwd.getBytes("UTF-8"));
		System.out.println("javaMd532：" + javaMd532);
		// 直接使用apache中codec中的DigestUtil生成32位MD5码
		System.out.println("DigestUtil生成:" + DigestUtils.md5Hex(pwd.getBytes("UTF-8")));
		// 使用shiro中的类看这篇文章进行加密解密:http://jinnianshilongnian.iteye.com/blog/2021439
		// Md5Hash
	}

	/**
	 * java生成32位MD5码
	 * 
	 * @param input
	 * @return
	 */
	public static String javaMd5Hex2(byte[] input) {
		/**
		 * MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。<br>
		 * 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。<br>
		 * MessageDigest 对象开始被初始化。该对象通过使用 update（）方法处理数据。<br>
		 * 任何时候都可以调用 reset（）方法重置摘要。<br>
		 * 一旦所有需要更新的数据都已经被更新了，应该调用digest() 方法之一完成哈希计算。<br>
		 * 对于给定数量的更新数据，digest方法只能被调用一次。 <br>
		 * 在调用 digest 之后，MessageDigest 对象被重新设置成其初始状态。
		 */
		/**
		 * 标准的md5函数是生成128位的<br>
		 * 但是由于128位的标准存储起来也较为麻烦，而且事实上这么长实际也没必要这么强大， 截取32位在密码上用的比较多，
		 */
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5"); // 得到MD5MessageDigest
			messageDigest.update(input); // 通过使用 update（）方法处理数据
			byte[] digestBytes = messageDigest.digest(); // digest方法获得结果，并重置MessageDigest
															// 对象被重新设置成其初始状态。
			// 128位MD5转换为32位小写MD5码
			StringBuffer sb = new StringBuffer();
			for (byte b : digestBytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					sb.append(0);
				}
				sb.append(Integer.toHexString(bt));
			}
			String result = sb.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
