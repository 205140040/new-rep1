package com.demo.state;

public class ProgressState implements State {

	public void handle(StateMachine machine) {
		System.out.println("进行中状态:");
		machine.setState(new CompletedStae());
	}

}
