package com.serdarormanli.brainfuck;

import java.io.IOException;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import com.serdarormanli.brainfuck.interpreter.FileInterpreter;
import com.serdarormanli.brainfuck.interpreter.InputInterpreter;
import com.serdarormanli.brainfuck.interpreter.Interpreter;

public class App {
	@Option(name = "-s", usage = "Simple input for source code")
	private String source;

	@Option(name = "-f", usage = "input file path")
	private String filePath;

	public static void main(String[] args) throws IOException {
		new App().doMain(args);
	}

	public void doMain(String[] args) throws IOException {
		CmdLineParser parser = new CmdLineParser(this);

		Interpreter in;

		try {
			parser.parseArgument(args);

			if ((source == null || source.trim().isEmpty()) && (filePath == null || filePath.trim().isEmpty())) {
				throw new CmdLineException(parser, "No argument is given");
			}

		} catch (CmdLineException e) {
			System.err.println(e.getMessage());
			System.err.println("java SampleMain [options...] arguments...");

			parser.printUsage(System.err);
			System.err.println();

			return;
		}

		if (source != null && !source.trim().isEmpty()) {
			in = new InputInterpreter(source);
		} else {
			in = new FileInterpreter(filePath);
		}

		in.interpret();

		System.out.println();
	}
}
