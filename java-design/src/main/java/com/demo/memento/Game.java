package com.demo.memento;

public class Game {
	protected double money;

	protected String progress;

	// 备份对象
	public Memento back(double m, String progress) {
		Memento memento = new Memento();
		memento.setMoney(m);
		memento.setProgress(progress);
		return memento;
	}

	// 恢复对象
	public void restore(Memento memento) {
		this.money = memento.getMoney();
		this.progress = memento.getProgress();
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "Game [money=" + money + ", progress=" + progress + "]";
	}

}
