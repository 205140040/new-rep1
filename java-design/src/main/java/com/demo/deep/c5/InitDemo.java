package com.demo.deep.c5;

import static com.demo.deep.c6.StaticImport.*;

public class InitDemo {

	public static void main(String[] args) {
		// 数组初始化
		int[] a = new int[6];
		params(a);
		System.out.println();
		// 枚举简单使用
		System.out.println(ColorEnum.BLUE);
		for (ColorEnum s : ColorEnum.values()) {
			System.out.println(s);
		}
		println("静态导入使用：improt static 类.*");
	}

	/**
	 * 可变参数
	 */
	public static void params(int... params) {
		for (int i : params) {
			System.out.print(i + ",");
		}
	}

}
