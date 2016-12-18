package com.yfairy.demo.thinkinginjava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ThinkInJava {

	private static final double PI = 3.1415926;

	public static void main(String[] args) {
		/**
		 * 1.章对象入门: <br>
		 * public所有包都可访问，protected当前包及子类可以访问，<br>
		 * default默认的，当前包可访问，private当前类可访问<br>
		 * 1.11 JAVA和因特网 第2章：47/688<br>
		 * 2.8.1注释文档57/688<br>
		 * javadoc用于提取注释的工具<br>
		 * 第三章：控制程序流程 61/688<br>
		 * 第5章：124/688<br>
		 * 第7章：161<br>
		 * 7.6内部类（重要)<br>
		 * 7.6.2方法和作用域中的内部类182/688<br>
		 * 7.7 199<br>
		 * 第八章：容器 第15章：网络编程538/688<br>
		 */
		System.out.println(new Date().toLocaleString());
		Properties properties = System.getProperties();
		properties.list(System.out);
		System.out.println("---------------------------------------------");
		System.out.println("Memory Usage");
		Runtime rt = Runtime.getRuntime();
		System.out.println("totalMemory:" + rt.totalMemory() + "\tfreeMemory:" + rt.freeMemory());
		// 可在for循环（）中设置,号，设置多个变量及改变变量值
		for (int i = 0, j = (i + 3); i < 20; i++, j = (i + 3)) {
			System.out.println("I:" + i + "\t+J:" + j);
		}
		/**
		 * 为什么重载不根据返回值识别?<br>
		 * 若编译器可根据上下文（语境）明确判断出含义，比如在 int x=f()中，那么这样做完全没有问题。然而，<br>
		 * 我们也可能调用一个方法，同时忽略返回值；我们通常把这称为“为它的副作用去调用一个方法”，因为我<br>
		 * 们关心的不是返回值，而是方法调用的其他效果。所以假如我们象下面这样调用方法：<br>
		 * f();Java 怎样判断 f()的具体调用方式呢？而且别人如何识别并理解代码呢？由于存在这一类的问题，所以不能<br>
		 * 根据返回值类型来区分过载的方法。<br>
		 */
		// final值不可改变
		// PI=222;
		List<Child> childs = new ArrayList<>();
		childs.add(new Child("aaa"));
		Child c1 = childs.get(0);
		System.out.println(c1.getName());
		// Collection<E>
		// Map<K, V>
	}

}
