package com.demo.chain;

public class LimitSupport extends Support {
	private int limit;

	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}

	/**
	 * 小鱼limit可解决问题
	 */
	@Override
	public boolean resolve(Trouble trouble) {
		if (trouble.getNumber() < limit) {
			return true;
		}
		return false;
	}

}
