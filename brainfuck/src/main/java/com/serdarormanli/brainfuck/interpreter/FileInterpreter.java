package com.serdarormanli.brainfuck.interpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.serdarormanli.brainfuck.operation.Operator;

public class FileInterpreter extends AbstractInterpreter {

	public FileInterpreter(String input) throws IOException {
		super(new String(Files.readAllBytes(Paths.get(input))).chars().mapToObj(c -> new Character((char) c)).filter(i -> Operator.isSymbol(i)).collect(Collectors.toList()));
	}
}
