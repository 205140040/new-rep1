package com.demo.state;

public class Test {

	public static void main(String[] args) {
		/**
		 * 把复杂的条件设置成不同的状态类，并进行相应的处理
		 * 在状态类中根据条件改变状态
		 */
		StateMachine stateMachine = new StateMachine();
		stateMachine.setState(new StartState());
		while (stateMachine.getState() != null) {
			stateMachine.getState().handle(stateMachine);
		}
	}

}
