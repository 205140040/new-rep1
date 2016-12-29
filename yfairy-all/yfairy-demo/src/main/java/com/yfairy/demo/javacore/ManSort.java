package com.yfairy.demo.javacore;

import java.util.Comparator;

public class ManSort implements Comparator<ManSort> ,Cloneable{

	private String name;

	private Integer age;

	public ManSort() {
		super();
	}

	public ManSort(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	// 按名称排序
	@Override
	public int compare(ManSort o1, ManSort o2) {
		String o1name = o1.getName();
		String o2name = o2.getName();
		return o1name.compareTo(o2name);
	}

	@Override
	public String toString() {
		return "ManSort [name=" + name + ", age=" + age + "]";
	}
	
	/**
	 * 实现Cloneable，实现克隆,clone方法可用于复制对象属性
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
