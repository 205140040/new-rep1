package com.demo.command;

import java.util.Stack;

public class MaroCommand implements Command {
	// 命令集合
	private Stack<Command> commands = new Stack<Command>();

	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}

	public void append(Command command) {
		if (this != command) {
			commands.push(command);
		}

	}

	// 删除最后一个命令
	public void undo() {
		if (null != commands) {
			commands.pop();
		}
	}

	// 全部删除
	public void clear() {
		commands.clear();
	}
}
