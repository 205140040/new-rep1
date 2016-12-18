package com.yfairy.demo.thinkinginjava;

import com.yfairy.demo.thinkinginjava.Neibulei.Content;
import com.yfairy.demo.thinkinginjava.Neibulei.StaticNeibulei;

public class NeibuleiTest {
	public static void main(String[] args) {
		// 在该类外部使用内部类时，使用new该内部类的外部类.new 内部类
		Content content = new Neibulei().new Content();
		System.out.println("在该类外部使用内部类时，使用new该内部类的外部类.new 内部类:" + content.value());
		// 访问private内部类,报错：PrivateNeibulei cannot be resolved to a type
		// PrivateNeibulei privateNeibulei = new Neibulei().new
		// PrivateNeibulei();
		// System.out.println("privateNeibulei:" + privateNeibulei.value());
		// 静态内部类，为了达到不用创建（new ）封装内，即可使用内部类的目的
		System.out.println("-------------------------");
		StaticNeibulei staticNeibulei = new StaticNeibulei();
		System.out.println(staticNeibulei.value());
	}
}
