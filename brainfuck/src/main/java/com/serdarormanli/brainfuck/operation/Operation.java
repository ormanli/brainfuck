package com.serdarormanli.brainfuck.operation;

import com.serdarormanli.brainfuck.data.InputCommand;
import com.serdarormanli.brainfuck.data.InputData;

@FunctionalInterface
public interface Operation {
	public void apply(InputData input, InputCommand command);
}
