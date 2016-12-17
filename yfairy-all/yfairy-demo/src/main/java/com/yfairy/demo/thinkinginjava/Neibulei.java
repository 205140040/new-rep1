package com.yfairy.demo.thinkinginjava;

/**
 * 内部类
 * 
 * @author jiangzi
 *
 */
public class Neibulei {

	private String name;

	/**
	 * 类中的内部类
	 * 
	 * @author jiangzi
	 *
	 */
	class Content {
		private int i = 11;

		public int value() {
			System.out.println("访问内部类所在的类的属性：" + getName());
			return i;
		}
	}

	/**
	 * 
	 * @author jiangzi 私有的内部类，通常情况建立的class只能是默认或者public，只有内部类才能设置访问权限为private
	 */
	private class PrivateNeibulei {
		private String pname = "PrivateNeibulei";

		public String value() {
			return pname;
		}
	}

	public void useNeibulei() {
		// 在该类内部使用内部类，直接new 即可
		Content content = new Content();
		System.out.println("content.value:" + content.value());
	}

	/**
	 * 提供一个外部直接获取内部类的方法
	 * 
	 * @return
	 */
	public Content getContent() {
		return new Content();
	}

	public void neibuleiInMethod() {
		// 方法中的内部类,会在方法外失效
		class NeibuleiInMethod {
			public int value() {
				return 10;
			}
		}
		NeibuleiInMethod neibuleiInMethod = new NeibuleiInMethod();
		System.out.println("方法中的内部类value:" + neibuleiInMethod.value());
	}

	public static void main(String[] args) {
		// 在该类内部使用内部类，直接new 即可
		Neibulei neibulei = new Neibulei();
		neibulei.setName("aaa");
		neibulei.useNeibulei();
		// 在该类外部使用内部类时，使用new该内部类的外部类.new 内部类
		Content content = new Neibulei().new Content();
		System.out.println("在该类外部使用内部类时，使用new该内部类的外部类.new 内部类:" + content.value());
		// 3.提供一个外部直接获取内部类的方法,从而快速new 一个内部类
		Neibulei.Content content2 = new Neibulei().getContent();
		System.out.println("提供一个外部直接获取内部类的方法:" + content2.value());
		// 私有的内部类，通常情况建立的class只能是默认或者public，只有内部类才能设置访问权限为private
		// 私有的内部类只能在当前内种访问，其他类里无法访问
		PrivateNeibulei privateNeibulei = new Neibulei().new PrivateNeibulei();
		System.out.println("privateNeibulei:" + privateNeibulei.value());
		// 方法中的内部类,会在方法外失效,报错：NeibuleiInMethod cannot be resolved to a type
		neibulei.neibuleiInMethod();
		// NeibuleiInMethod neibuleiInMethod=new NeibuleiInMethod();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
