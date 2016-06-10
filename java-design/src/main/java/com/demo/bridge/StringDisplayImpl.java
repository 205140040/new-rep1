package com.demo.bridge;

/**
 * 实现的类层次
 * 
 * @author admin 2016年6月10日
 * @description
 * @ClassName StringDisplayImpl
 */
public class StringDisplayImpl extends DisplayImpl {

	private String s;

	public StringDisplayImpl(String s) {
		super();
		this.s = s;
	}

	@Override
	public void rawOpen() {
		System.out.println("-----------open------------");
	}

	@Override
	public void rawPrint() {
		System.out.println("|\t" + s + "\t|");
	}

	@Override
	public void rawClose() {
		System.out.println("-----------close------------");

	}

}
