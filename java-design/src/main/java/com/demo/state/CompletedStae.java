package com.demo.state;

public class CompletedStae implements State {

	public void handle(StateMachine machine) {
		System.out.println("完成状态");
		machine.setState(null);
	}

}
