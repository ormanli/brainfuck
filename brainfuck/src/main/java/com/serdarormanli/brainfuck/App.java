package com.serdarormanli.brainfuck;

import com.serdarormanli.brainfuck.interpreter.InputInterpreter;
import com.serdarormanli.brainfuck.interpreter.Interpreter;

public class App {
	public static void main(String[] args) {
		Interpreter in = new InputInterpreter("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
		in.interpret();
	}
}
