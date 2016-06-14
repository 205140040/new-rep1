package com.demo.observer;

public class DigitObserver implements Observer {

	public void update(NumberGenerator numberGenerator) {
		System.out.println("DigitObserver观察到的number：" + numberGenerator.getNumber());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
