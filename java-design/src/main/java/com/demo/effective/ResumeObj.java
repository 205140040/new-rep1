package com.demo.effective;

public class ResumeObj {
	/**
	 * 尽量复用对象，以提高性能
	 */
	private static String string;
	static {
		string = "555";
	}

	public static String now() {
		return string;
	}

	public static void main(String[] args) {
		System.out.println(now());
		System.out.println(now());
		System.out.println(now());
		System.out.println(now());
		/**
		 * 尽量先使用基本类型，少用包装类型，这样可以提高性能 下面的Long改为long程序从43秒变为6.8秒
		 * 
		 * Long sum=0L; for (long i = 0; i < 5000; i++) { sum=sum+i; }
		 * System.out.println(sum);
		 */
	}
}
