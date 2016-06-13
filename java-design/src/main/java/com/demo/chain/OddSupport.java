package com.demo.chain;

public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
	}

	/**
	 * 处理奇数问题的类
	 */
	@Override
	public boolean resolve(Trouble trouble) {
		if(trouble.getNumber()%2==1){
			return true;
		}
		return false;
	}

}
