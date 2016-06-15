package com.demo.memento;

public class Test {

	public static void main(String[] args) {
		Game game = new Game();
		game.setMoney(1000);
		game.setProgress("第一关");
		System.out.println(game);
		Memento memento = game.back(game.getMoney(), game.getProgress());// 备份第一关
		game.setMoney(600);
		game.setProgress("第二关");
		System.out.println(game);
		game.setMoney(300);
		game.setProgress("第三关");
		System.out.println(game);
		game.restore(memento);
		System.out.println(game);
	}

}
