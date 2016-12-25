package com.yfairy.demo.javacore;

public class CommandArgsDemo {

	public static void main(String[] args) {
		// 通过java 类名 参数 ，实现命令行获取参数,如java CommandArgsDemo arg1 arg2
		for (int i = 0; i < args.length; i++) {
			System.out.println("参数" + i + ":" + args[i]);
		}
	}

}
