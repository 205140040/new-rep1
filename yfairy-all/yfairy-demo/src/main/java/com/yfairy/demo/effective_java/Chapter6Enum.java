package com.yfairy.demo.effective_java;

import java.lang.reflect.Method;

public class Chapter6Enum {

	public @interface TestException {

		Class<? extends Exception> value();

		String name() default "";

	}

	static class UseTestException {

		@TestException(NullPointerException.class)
		public void m1() {
			System.out.println("m1");
//			throw new NullPointerException();
		}

		@TestException(NullPointerException.class)
		public void m2() {
			System.out.println("m2");
		}
	}

	public static void main(String[] args) {
		/**
		 * 第6章：枚举和注解128(141/303)<br>
		 * 30用Enum代替常量<br>
		 * 枚举可以限定常量值必须是枚举类中定义的，而普通常量无法现在，枚举更灵活<br>
		 * 31条用实例域代替序数<br>
		 * 32条用EnumSet代替位域<br>
		 * 34条用接口模拟可伸缩的枚举<br>
		 * 35注解优先于命名模式<br>
		 * 36条坚持使用override注解<br>
		 * 37用标记接口定义类型<br>
		 */
		ColorEnum[] colorEnums = ColorEnum.values();
		for (ColorEnum colorEnum : colorEnums) {
			System.out.println(colorEnum);
			System.out.println(colorEnum.getValue());
		}

		/**
		 * 
		 * 使用一个类模拟枚举
		 */
		ColorClassEnum[] classEnums = ColorClassEnum.values();
		for (ColorClassEnum ce : classEnums) {
			System.out.println(ce);
			System.out.println(ce.getValue());
		}

		// 通过注解调用方法，获取注解上的异常
		Class<UseTestException> class1 = UseTestException.class;
		UseTestException ute = new UseTestException();
		Method[] ms = class1.getDeclaredMethods();
		for (Method method : ms) {
			System.out.println(method);
			TestException te = method.getAnnotation(TestException.class);
			System.err.println("值:"+te.value());
			try {
				method.invoke(ute);
			} catch (Exception e) {
				

				if (te.value() == NullPointerException.class) {
					System.out.println();
					e.printStackTrace();
				}
			}
		}
	}

	enum ColorEnum {
		RED("red"), YELLOW("yellow"), BLUE("blue");

		private String value;

		private ColorEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}

	/**
	 * 
	 * @author jiangzi 使用一个类模拟枚举
	 */
	static class ColorClassEnum {

		private final String value;

		private ColorClassEnum(String value) {
			super();
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static final ColorClassEnum RED = new ColorClassEnum("red");

		public static final ColorClassEnum YELLOW = new ColorClassEnum("yellow");

		public static final ColorClassEnum BLUE = new ColorClassEnum("blue");

		public static ColorClassEnum[] values() {
			ColorClassEnum[] values = { RED, YELLOW, BLUE };
			return values;
		}

	}

}
