package com.yfairy.demo.encrypt;

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringUtilDemo {

	public static void main(String[] args) {
		/**
		 * 使用apache中RandomStringUtils<br>
		 * 
		 * RandomStringUtils.random(5);<br>
		 * //产生5位长度的随机字符串<br>
		 * 
		 * //使用指定的字符生成5位长度的随机字符串 <br>
		 * RandomStringUtils.random(5, new char[]{'a','b','c','d','e','f'});<br>
		 * 
		 * //生成指定长度的字母和数字的随机组合字符串 <br>
		 * RandomStringUtils.randomAlphanumeric(5);<br>
		 * 
		 * //生成随机数字字符串 <br>
		 * RandomStringUtils.randomNumeric(5);<br>
		 */
		String s1 = RandomStringUtils.random(6);
		System.out.println("产生6位长度的随机字符串:" + s1);
		String s2 = RandomStringUtils.random(6, new char[] { 'a', 'b', 'c', 'd', 'e', 'f' });
		System.out.println("指定的字符生成指定长度的随机字符串:" + s2);
		String s3 = RandomStringUtils.randomNumeric(6);
		System.out.println("生成指定长度的随机数字字符串:" + s3);
		String s4 = RandomStringUtils.randomAlphanumeric(6);
		System.out.println("生成指定长度,字母+数字的随机字符串:" + s4);
	}

}
