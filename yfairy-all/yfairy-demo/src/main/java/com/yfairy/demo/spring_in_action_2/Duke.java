package com.yfairy.demo.spring_in_action_2;

public class Duke implements IDukeService {

	@Override
	public void sayDuke() {
		System.out.println("duke");
	}

	@Override
	public String sayName(String name) {
		System.out.println("hello," + name);
		return name;
	}

}
