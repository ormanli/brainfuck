package com.serdarormanli.brainfuck.data;

import java.util.List;

public class InputCommand {
	private final List<Character> commands;
	public int index = 0;

	public InputCommand(List<Character> commands) {
		this.commands = commands;
	}

	public List<Character> getCommands() {
		return commands;
	}

	public char getCurrentCommand() {
		return commands.get(index);
	}

}
