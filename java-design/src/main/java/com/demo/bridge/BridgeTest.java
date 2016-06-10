package com.demo.bridge;

public class BridgeTest {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("hello"));
		d1.display();
		CountDisplay md = new CountDisplay(new StringDisplayImpl("multi world"));
		md.multiDisplay(3);
	}

}
