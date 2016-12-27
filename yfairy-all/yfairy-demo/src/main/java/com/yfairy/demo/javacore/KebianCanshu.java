package com.yfairy.demo.javacore;

public class KebianCanshu {

	public static void main(String[] args) {
		/**
		 * 可变参数，如:Object ... args
		 */
		sum(1, 2, 3, 4, 5, 6);
	}

	public static void sum(Integer... num) {
		Integer sum = 0;
		System.out.println("---------------------");
		for (Integer n : num) {
			System.out.print(n + "\t");
			sum += n;
		}
		System.out.println();
		System.out.println("和:" + sum);
	}

}
