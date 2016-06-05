package com.demo.prototype;

public class Test {
	public static void main(String[] args) {
		Manager manager = new Manager();
		MessageBox messageBox = new MessageBox("啦啦啦");
		manager.register("m1", messageBox);
		Product c1 = manager.create("m1");
		c1.use("bb");
	}
}
