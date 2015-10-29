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
		data.incrementData();
		command.index++;
	}), //
	DECREMENT('-', (data, command) -> {
		data.decrementData();
		command.index++;
	}), //
	RIGHT('>', (data, command) -> {
		data.incrementIndex();
		command.index++;
	}), //
	LEFT('<', (data, command) -> {
		data.decrementIndex();
		command.index++;
	}), //
	DOT('.', (data, command) -> {
		System.out.print((char) data.getCurrentData());
		command.index++;
	}), //
	COMMA(',', (data, command) -> {
		try (Scanner s = new Scanner(System.in)) {
			data.setCurrentData(s.next().charAt(0));
		}
		command.index++;

	}), //
	LEFT_BRACKET('[', (data, command) -> {
		if (data.getCurrentData() == 0) {
			while (!command.getCurrentCommand().equals(Character.valueOf(']'))) {
				command.index++;
			}
		} else {
			command.index++;
		}
	}), //
	RIGHT_BRACKET(']', (data, command) -> {
		if (data.getCurrentData() == 0) {
			command.index++;
		} else {
			while (!command.getCurrentCommand().equals(Character.valueOf('['))) {
				command.index--;
			}
		}
	});

	private Operation operation;
	private Character symbol;

	public Operation getOperation() {
		return operation;
	}

	public Character getSymbol() {
		return symbol;
	}

	private Operator(Character symbol, Operation operation) {
		this.operation = operation;
		this.symbol = symbol;
	}

	private static final Map<Character, Operator> lookup = EnumSet.allOf(Operator.class).stream().collect(Collectors.toMap(Operator::getSymbol, Function.identity()));

	public static boolean isSymbol(Character symbol) {
		return lookup.containsKey(symbol);
	}

	public static void apply(InputData data, InputCommand commands) {
		lookup.get(commands.getCurrentCommand()).operation.apply(data, commands);
	}
}
