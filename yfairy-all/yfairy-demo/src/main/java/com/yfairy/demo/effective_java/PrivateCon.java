package com.yfairy.demo.effective_java;

public class PrivateCon {

	public static void main(String[] args) {
		/**
		 * 通过设置构造器方法为private，强化不可实例化的能力<br>
		 * 比如某些Util，设置私有的构造方法<br>
		 * public final class Math {
		 * 
		 * 
		 * Don't let anyone instantiate this class.
		 * 
		 * private Math() {}
		 */

		// Math math=new math

		// 报错The constructor HelloUtil() is not visible
		// HelloUtil helloUtil=new HelloUtil();
		HelloUtil.hello();

	}

}
