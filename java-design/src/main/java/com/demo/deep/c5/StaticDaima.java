package com.demo.deep.c5;

public class StaticDaima {
	public static int i;
	private int j;
	
	/**
	 * 静态代码块:当创建该类时只初始化一次
	 */
	static{
		i=5;
	}
	
	/**
	 * 非静态代码块,用来初始化实例变量的值
	 */
	{
		j=5;
	}

	public static void main(String[] args) {
		System.out.println(i);
	}

}
