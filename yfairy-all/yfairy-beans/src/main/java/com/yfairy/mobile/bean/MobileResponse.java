package com.yfairy.mobile.bean;

public class MobileResponse {

	public static final String SUCCESS_CN_MSG = "成功";

	private Boolean flag;

	private Integer code;

	private String msg;

	private Object data;

	public static MobileResponse trueMsg(String msg) {
		MobileResponse res = new MobileResponse();
		res.setFlag(true);
		res.setCode(1);
		res.setMsg(msg);
		return res;
	}

	public static MobileResponse trueMsgAndData(String msg, Object data) {
		MobileResponse res = new MobileResponse();
		res.setFlag(true);
		res.setCode(1);
		res.setMsg(msg);
		res.setData(data);
		return res;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
