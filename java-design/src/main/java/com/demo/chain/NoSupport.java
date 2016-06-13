package com.demo.chain;

public class NoSupport extends Support {

	public NoSupport(String name) {
		super(name);
	}

	/**
	 * 不支持任何问题处理
	 */
	@Override
	public boolean resolve(Trouble trouble) {
		return false;
	}

}
