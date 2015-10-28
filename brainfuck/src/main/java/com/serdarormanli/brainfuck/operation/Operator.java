package com.serdarormanli.brainfuck.operation;

import java.util.EnumSet;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.serdarormanli.brainfuck.data.InputCommand;
import com.serdarormanli.brainfuck.data.InputData;

public enum Operator {

	INCREMENT('+', (data, command) -> {
		data.data[data.index]++;
		command.index++;
	}), //
	DECREMENT('-', (data, command) -> {
		data.data[data.index]--;
		command.index++;
	}), //
	RIGHT('>', (data, command) -> {
		data.index++;
		command.index++;
	}), //
	LEFT('<', (data, command) -> {
		data.index--;
		command.index++;
	}), //
	DOT('.', (data, command) -> {
		System.out.print((char) data.data[data.index]);
		command.index++;
	}), //
	COMMA(',', (data, command) -> {
		try (Scanner s = new Scanner(System.in)) {
			data.data[data.index] = s.next().charAt(0);
		}
		command.index++;

	}), //
	LEFT_BRACKET('[', (data, command) -> {
		if (data.data[data.index] == 0) {
			while (!command.getCommands().get(command.index).equals(Character.valueOf(']'))) {
				command.index++;
			}
		} else {
			command.index++;
		}
	}), //
	RIGHT_BRACKET(']', (data, command) -> {
		if (data.data[data.index] == 0) {
			command.index++;
		} else {
			while (!command.getCommands().get(command.index).equals(Character.valueOf('['))) {
				command.index--;
			}
		}
	});

	private Operation operation;
	private char symbol;

	public Operation getOperation() {
		return operation;
	}

	public char getSymbol() {
		return symbol;
	}

	private Operator(char symbol, Operation operation) {
		this.operation = operation;
		this.symbol = symbol;
	}

	private static final Map<Character, Operator> lookup = EnumSet.allOf(Operator.class).stream().collect(Collectors.toMap(Operator::getSymbol, Function.identity()));

	public static Operator get(Character symbol) {
		return lookup.get(symbol);
	}

	public static boolean isSymbol(Character symbol) {
		return lookup.containsKey(symbol);
	}

	public static void apply(InputData data, InputCommand commands) {
		get(commands.getCommands().get(commands.index)).operation.apply(data, commands);
	}
}
