package com.demo.command;

import java.awt.Point;

public class DrawCommand implements Command {
	// 绘制对象
	private Drawable drable;
	// 绘制位置
	private Point position;
	

	private DrawCommand(Drawable drable, Point position) {
		super();
		this.drable = drable;
		this.position = position;
	}


	public void execute() {
		System.out.println("执行绘画");
		drable.draw(position.x, position.y);
	}

}
