package com.demo.deep.c12;
/**
 * 1.自定义异常，继承自exception
 * 定义无参数构造方法，有参数构造方法
 */
public class Exception1 extends Exception {
	
	private Integer errorCode; 

	/**
	 * @author admin 2016年6月28日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	public Exception1() {
		super();
	}

	public Exception1(String message) {
		super(message);
	}

	/**
	 * 为异常添加额外的构造方法
	 */
	public Exception1(String message,int errorCode) {
		super(message);
		this.errorCode=errorCode;
	}
	
	/**
	 * 重写异常类的getmessage方法（类似于tostirng方法）
	 * 设置异常的详细信息
	 */
	@Override
	public String getMessage() {
		return "errorCode:"+this.errorCode+"，"+ super.getMessage();
	}
}
