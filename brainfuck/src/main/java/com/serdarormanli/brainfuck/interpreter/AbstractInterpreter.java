package com.serdarormanli.brainfuck.interpreter;

import java.util.List;

import com.serdarormanli.brainfuck.data.InputCommand;
import com.serdarormanli.brainfuck.data.InputData;
import com.serdarormanli.brainfuck.operation.Operator;

public abstract class AbstractInterpreter implements Interpreter {
	private InputData input = new InputData();
	final InputCommand commands;

	public AbstractInterpreter(List<Character> commands) {
		this.commands = new InputCommand(commands);
	}

	@Override
	public final void interpret() {
		while (commands.index < commands.getCommands().size()) {
			Operator.apply(input, commands);
		}
	}
}
