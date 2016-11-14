package com.yfairy.demo.encrypt;

public class EncryptDemo {

	public static void main(String[] args) {
		/**
		 * 常用加密方式: 1.Base64:Base64是网络上最常见的用于传输8Bit字节代码的编码方式之一，<br>
		 * 大家可以查看RFC2045～RFC2049，上面有MIME的详细规范。<br>
		 * Base64编码可用于在HTTP环境下传递较长的标识信息。<br>
		 * 例如，在Java Persistence系统Hibernate中，<br>
		 * 就采用了Base64来将一个较长的唯一标识符（一般为128-bit的UUID）编码为一个字符串，<br>
		 * 用作HTTP表单和HTTP GET URL中的参数。在其他应用程序中，<br>
		 * 也常常需要把二进制数据编码为适合放在URL（包括隐藏表单域）中的形式。<br>
		 * 此时，采用Base64编码具有不可读性，<br>
		 * 即所编码的数据不会被人用肉眼所直接看到。<br>
		 * (http://baike.baidu.com/link?url=UzAmxFRwtL9kWepQOWJrFHbagLvh639yerLc2nx6hXGFDzTtPSnJ6VC11BI19GZed0vTZc4FO-1phdliexrpUa)
		 * <br>
		 * <br>
		 * <br>
		 * 2.MD5:Message Digest Algorithm MD5（中文名为消息摘要算法第五版）
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
		 * <br>
		 * <br>
		 */
		// MessageDigest.getInstance(algorithm)
	}

}
