package com.serdarormanli.brainfuck.interpreter;

import java.util.stream.Collectors;

import com.serdarormanli.brainfuck.operation.Operator;

public class InputInterpreter extends AbstractInterpreter {

	public InputInterpreter(String input) {
		super(input.chars().mapToObj(c -> new Character((char) c)).filter(i -> Operator.isSymbol(i)).collect(Collectors.toList()));
	}

}
