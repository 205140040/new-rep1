package com.demo.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
	// 观察者
	private List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObserver() { // 通知观察者
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	public abstract int getNumber();// 取得数值

	public abstract void execute(); // 产生数值
}
