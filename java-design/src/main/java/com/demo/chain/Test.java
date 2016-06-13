package com.demo.chain;

public class Test {

	public static void main(String[] args) {
		Support noSupport=new NoSupport("no");
		Support limitSupport=new LimitSupport("limit", 6);
		OddSupport oddSupport=new OddSupport("奇数");
		SpecialSupport specialSupport=new SpecialSupport("特别处理", 6);
		noSupport.setNext(limitSupport).setNext(oddSupport).setNext(specialSupport);
		for (int i = 0; i <10; i++) {
			noSupport.support(new Trouble(i));
		}
	}

}
