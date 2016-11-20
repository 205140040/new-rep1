package com.yfairy.demo.encrypt;

import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.rsa.crypto.RsaSecretEncryptor;

public class RSADemo {

	public static void main(String[] args) {
		/**
		 * 非对称加密算法（百度百科）<br>
		 * 非对称加密算法是一种密钥的保密方法。<br>
		 * 非对称加密算法需要两个密钥：公开密钥（publickey）和私有密钥（privatekey）。<br>
		 * 公开密钥与私有密钥是一对，如果用公开密钥对数据进行加密，<br>
		 * 只有用对应的私有密钥才能解密；如果用私有密钥对数据进行加密，<br>
		 * 那么只有用对应的公开密钥才能解密。因为加密和解密使用的是两个不同的密钥，<br>
		 * 所以这种算法叫作非对称加密算法。<br>
		 * 非对称加密算法实现机密信息交换的基本过程是：<br>
		 * 甲方生成一对密钥并将其中的一把作为公用密钥向其它方公开；<br>
		 * 得到该公用密钥的乙方使用该密钥对机密信息进行加密后再发送给甲方；<br>
		 * 甲方再用自己保存的另一把专用密钥对加密后的信息进行解密。<br>
		 * 主要算法： RSA、Elgamal、背包算法、Rabin、D-H、ECC（椭圆曲线加密算法）。
		 * 使用最广泛的是RSA算法，Elgamal是另一种常用的非对称加密算法。
		 */
		// MessageDigest.getInstance(algorithm)
		/**
		 * spring-security-rsa中的示列， TODO 继续看java如何使用RSA
		 */
		TextEncryptor encryptor = new RsaSecretEncryptor();
		String cipher = encryptor.encrypt("my message");
		String message = encryptor.decrypt(cipher);
	}

}
