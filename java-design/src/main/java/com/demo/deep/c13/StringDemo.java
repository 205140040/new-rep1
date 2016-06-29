package com.demo.deep.c13;

import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {

	
	public static void main(String[] args) {
		/**
		 * stirng：不可变类
		 * 2.s1+s2 jvm会使用stringBuidler帮你构建，但是循环+字符串时建议直接使用stringBuidler
		 */
		String s1="555";
		Integer d1=8;
		//类似c语言的格式化字符串
		Formatter format=new Formatter(System.out);
		format.format("%s:%d", s1,d1);
		System.out.println();
		//String.format()
		System.out.println(String.format("%s:%d", s1,d1));
		/**
		 * 正则表达式
		 * '/'d数字,a-z,?表示可能有,+表示至少有,^表示非
		 */
		String regex1="^[0-9]+$";
		Pattern pattern=Pattern.compile(regex1);
		Matcher matcher=pattern.matcher("589");
		System.out.println("是否匹配成功:"+matcher.matches());
		System.out.println("查找匹配到的对象:"+matcher.find());
		//System.out.println(matcher.group(0));
		//scaner,读取输入
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入姓名:");
		String name=scanner.nextLine();
		System.out.println(name+",你好");
		scanner.close();
		//stringBuilder比stringBuffer性能高
	}

}
