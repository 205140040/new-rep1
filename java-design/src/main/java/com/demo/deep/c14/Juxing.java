package com.demo.deep.c14;

public class Juxing extends Shape implements DyamicInterface {

	@Override
	public String toString() {
		return "Juxing";
	}

	public void sayHello() {
		System.out.println("hello");
	}
	
	private void myFun1(){
		System.out.println("myFun1私有方法被调用");
	}
}
