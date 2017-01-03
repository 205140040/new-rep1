package com.yfairy.demo.javacore;

import com.yfairy.demo.thinkinginjava.Parent;

/**
 * 泛型类
 * 
 * @author jiangzi
 *
 */
public class GenericType1<T extends Parent, U> {

	private T firstType;

	private U secondType;

	public GenericType1() {
		super();
	}

	public GenericType1(T firstType, U secondType) {
		super();
		this.firstType = firstType;
		this.secondType = secondType;
	}

	public T getFirstType() {
		return firstType;
	}

	public void setFirstType(T firstType) {
		this.firstType = firstType;
	}

	public U getSecondType() {
		return secondType;
	}

	public void setSecondType(U secondType) {
		this.secondType = secondType;
	}

	@Override
	public String toString() {
		return "GenericType1 [firstType=" + firstType + ", secondType=" + secondType + "]";
	}

	public static <T> T getAnyTypeInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

}
