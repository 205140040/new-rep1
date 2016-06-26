package com.demo.deep.c10;

/**
 * 内部类
 */
public class Leibulei {
	private int wvar = 5;

	/**
	 * 内部类拥有外围类元素的所有访问权限, 普通内部类拥有外围类的引用
	 */
	class Lbl1 {
		public String getName(String name) {
			System.out.println(wvar);
			return name;
		}
	}

	/**
	 * 嵌套内部类,无需外围类的引用
	 */
	static class Lbl2 {
		public void sayHello() {
			System.out.println("hello");
		}
	}

	public String getName(String name) {
		Lbl1 lbl1 = new Lbl1();
		return lbl1.getName(name);
	}

	public static void main(String[] args) {
		// 创建内部类，使用.new，需要先创建外部类，然后创建内部类
		Lbl1 lbl1 = new Leibulei().new Lbl1();
		lbl1.getName("5555");
		Lbl2 lbl2=new Leibulei.Lbl2();
		lbl2.sayHello();
	}
}
