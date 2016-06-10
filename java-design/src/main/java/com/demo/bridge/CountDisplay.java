package com.demo.bridge;

/**
 * 功能的类层次
 * 
 * @author admin 2016年6月10日
 * @description
 * @ClassName CountDisplay
 */
public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}

	public void multiDisplay(int count) {
		open();
		for (int i = 0; i < count; i++) {
			print();
		}
		close();
	}
}
