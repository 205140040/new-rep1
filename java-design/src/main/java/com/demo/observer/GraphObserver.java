package com.demo.observer;

public class GraphObserver implements Observer {

	public void update(NumberGenerator numberGenerator) {
		System.out.print("GraphObserver:");
		for (int i = 0; i < numberGenerator.getNumber(); i++) {
			System.out.print("*");
		}
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
