package com.yfairy.common.beans;

import java.io.Serializable;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean flag;

	private String msg;

	private Object object;

	public Result() {
		super();
	}

	public Result(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}

	public Result(boolean flag, String msg, Object object) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.object = object;
	}

	public static Result resultTrueSuccess() {
		return new Result(true, "操作成功!");
	}

	public static Result resultTrue(String msg) {
		return new Result(true, msg);
	}

	public static Result resultTrue(String msg, Object object) {
		return new Result(true, msg, object);
	}

	public static Result resultFalse(String msg) {
		return new Result(false, msg);
	}

	public static Result resultFalse(String msg, Object object) {
		return new Result(false, msg, object);
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
