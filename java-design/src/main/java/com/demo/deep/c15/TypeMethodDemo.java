package com.demo.deep.c15;

import java.util.ArrayList;
import java.util.List;

public class TypeMethodDemo {

	/**
	 * 泛型方法：要定义泛型方法，需要把泛型参数定义在方法返回值之前即可
	 */
	public <T> void getTypeName(T t) {
		System.out.println("className:" + t.getClass().getName());
	}

	/**
	 * 泛型方法结合可变参数使用
	 */
	public <T> void getArgs(T... ts) {
		for (T t : ts) {
			System.out.print(t + ",");
		}
		System.out.println();
	}

	/**
	 * 传递泛型class对象
	 */
	public <T> T typeClass(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new NullPointerException();
	}

	/**
	 * 泛型边界,使用T extends Object指定该泛型参数必须是某个对象，或其子类
	 * extends指定的是范围上限，表示该类型必须是该类或者其子类
	 */
	public <T extends Man> T getMan(T t) {
		return t;
	}

	/**
	 * 泛型边界，使用super，表示该类型必须是该类或者其超类
	 */
	public void getSuperMan() {
		List<? super Man> list = new ArrayList<Man>();
		// 报错:Type mismatch: cannot convert from ArrayList<ManChild> to List<?
		// super Man>
		// 使用super添加type子类时报错
		// List<? super Man> list2 = new ArrayList<ManChild>();
		// 添加超类泛型不报错,
		List<? super Man> list3 = new ArrayList<Object>();
	}

	public static void main(String[] args) {
		TypeMethodDemo methodDemo = new TypeMethodDemo();
		methodDemo.getTypeName(new Student());
		methodDemo.getArgs("a", "b", "c", "d");

		Student student = methodDemo.typeClass(Student.class);
		student.setName("哈哈哈");
		System.out.println(student.getName());

		Man man = methodDemo.getMan(new Man());
		System.out.println(man);
		/**
		 * 泛型缺点: 1.任何基本类型都不能作为泛型参数 2.实现泛型参数接口 2.无法重载，应为泛型会被擦除 4.无法在catch中使用泛型
		 */
	}
}
