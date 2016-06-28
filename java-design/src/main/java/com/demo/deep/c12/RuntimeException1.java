package com.demo.deep.c12;
/**
 * 运行时异常，也被称为不受检查型异常，无需try,catch或throws
 * 编译器会在运行时自动捕获该异常
 */
public class RuntimeException1 extends RuntimeException{

	/**
	 * @author admin
	 * 2016年6月28日
	 * @description 
	 */
	private static final long serialVersionUID = 1L;

	public RuntimeException1() {
		super();
	}

	public RuntimeException1(String message) {
		super(message);
	}

}
