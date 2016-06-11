package com.demo.strategy;

public class StrategyTest {

	/**
	 * 策略模式：规定算法的接口，
	 * 通过不同的实现，来灵活的改变算法
	 */
	public static void main(String[] args) {
		char[] cs = new char[3];
		cs[0] = 'a';
		cs[1] = 'b';
		cs[2] = 'c';
		Print p1 = new CharPrint(cs);
		p1.print();
		Print p2 = new StringPrint("hello");
		p2.print();
	}

}
