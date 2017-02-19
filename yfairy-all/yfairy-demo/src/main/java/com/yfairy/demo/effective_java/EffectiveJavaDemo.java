package com.yfairy.demo.effective_java;

public class EffectiveJavaDemo {

	public static void main(String[] args) {
		/**
		 * 第1章：引言14/303<br>
		 * 第2章：创建和销毁对象17/303<br>
		 * 第5条避免创建不必要的对象<br>
		 * 第3章：对于所有对象都通用的方法41/303<br>
		 * 第4章：类和接口71/303<br>
		 * 到17条要么为继承而设计76(89/303)<br>
		 * 第5章：泛型97(110/303)<br>
		 * 第6章：枚举和注解128(141/303)<br>
		 * 第7章:方法156(169/303)<br>
		 * 第8章：通用程序设计181(194/303)<br>
		 * 第9章:异常211(223/303)<br>
		 */
		System.out.println("hello world");

		// 第5条避免创建不必要的对象<br>
		// new String会在每次都在堆上创建一个对象，s2="s2"第一次不存在，后面的复用

		// new Boolean(true);每次都创建，Boolean.valueOf(true);会复用，避免创建多个
		// 创建包装类时，多用valueOf，避免创建多个对象
		String s1 = new String("s1");
		String s2 = "s2";
		Integer num = 5; // class反编译Integer num = Integer.valueOf(5);
		Boolean b1 = new Boolean(true);
		Boolean b2 = Boolean.valueOf(true);
	}

}
