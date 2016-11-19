package com.yfairy.demo.encrypt;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;

public class EncriptWithSaltDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 盐 (密码学)维基百科
		 * https://zh.wikipedia.org/wiki/%E7%9B%90_(%E5%AF%86%E7%A0%81%E5%AD%A6)
		 * 安全因素[编辑]<br>
		 * 通常情况下，当字段经过散列处理（如MD5），会生成一段散列值，<br>
		 * 而散列后的值一般是无法通过特定算法得到原始字段的。<br>
		 * 但是某些情况，比如一个大型的彩虹表，通过在表中搜索该MD5值，<br>
		 * 很有可能在极短的时间内找到该散列值对应的真实字段内容。<br>
		 * 加盐后的散列值，可以极大的降低由于用户数据被盗而带来的密码泄漏风险，<br>
		 * 即使通过彩虹表寻找到了散列后的数值所对应的原始内容，<br>
		 * 但是由于经过了加盐，插入的字符串扰乱了真正的密码，<br>
		 * 使得获得真实密码的概率大大降低。<br>
		 * 即把用户输入的密码+一个随机盐（字符串），然后再生产Hash码，<br>
		 * 如MD5码 (也可以先把用户密码拆分，然后在中间加盐)<br>
		 */
		// $salt="WIKIPEDIA"; //定义一个加盐字段(WIKIPEDIA)，一旦设定并使用，将不可更动。
		// $b=$a.$salt; //把密码和加盐字段连接。
		// $b=md5($b); //执行MD5散列。
		// return $b; //返回散列。
		List<String> code = Arrays.asList("A", "B", "C", "D", "E");

		// String salt1 = generateSalt(code) + generateSalt(code) +
		// generateSalt(code) + generateSalt(code)
		// + generateSalt(code) + generateSalt(code);
		// 使用阿帕奇:RandomStringUtils
		String salt1 = RandomStringUtils.randomAlphabetic(6);
		System.out.println(salt1);
		// java生成32位MD5码
		String pwd = "hello123worl.";

		/**
		 * 可以先把用户密码拆分，然后在中间加盐
		 */
		String pwdWithSalt = pwd + salt1;
		System.out.println("pwdWithSalt:" + pwdWithSalt);
		// RandomUtils
		// RandomStringUtils

		String javaMd532 = Md5Demo.javaMd5Hex2(pwdWithSalt.getBytes("UTF-8"));
		System.out.println("javaMd532：" + javaMd532);
		// 直接使用apache中codec中的DigestUtil生成32位MD5码
		System.out.println("DigestUtil生成:" + DigestUtils.md5Hex(pwd.getBytes("UTF-8")));
		System.out.println("DigestUtilSalt生成:" + DigestUtils.md5Hex(pwdWithSalt.getBytes("UTF-8")));
	}

	private static String generateSalt(List<String> code) {
		Random random = new Random();
		int randomNextRound = code.size() - 1;
		int nexInt = random.nextInt(randomNextRound);
		String randomCode = code.get(nexInt);
		return randomCode;
	}

}
