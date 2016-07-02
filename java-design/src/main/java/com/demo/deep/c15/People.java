package com.demo.deep.c15;

/**
 * 使用泛型，指定类型参数
 * 泛型类
 */
public class People<T> {

	private T t;

	public People(T t) {
		super();
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		/**
		 * 使用泛型，指定类型参数
		 */
		/**
		 * java泛型的核心概念：告诉编译器想使用什么类型，然后让编译器帮你处理转型等细节
		 */
		People<String> people = new People<String>("露露");
		System.out.println(people.getT());
	}
}
