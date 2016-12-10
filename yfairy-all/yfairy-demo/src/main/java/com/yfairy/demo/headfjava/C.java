package com.yfairy.demo.headfjava;

public class C extends P {
	C() {
		System.out.println("Child  init");
	}
	public static void main(String[] args) {
		/**
		 * 继承时会先执行父类的初始化
		 */
		C c=new C();
		
	}
}
