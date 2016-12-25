package com.yfairy.demo.javacore;

public class InitBlock {

	private String var1;

	private static String staticvar1;

	/**
	 * 初始化块,在一个类被加载时运行
	 */
	{
		var1 = "初始化变量1";
	}

	/**
	 * 静态初始化块,在类第一次加载时运行
	 */
	static {
		staticvar1 = "staticvar1";
	}

	public static void main(String[] args) {
		InitBlock initBlock = new InitBlock();
		System.out.println(initBlock.var1);
		System.out.println(InitBlock.staticvar1);
	}

	public String getVar1() {
		return var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

}
