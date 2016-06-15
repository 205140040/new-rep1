package com.demo.state;

public class StartState implements State {

	public void handle(StateMachine machine) {
		System.out.println("开始状态:");
		machine.setState(new ProgressState());
	}

}
