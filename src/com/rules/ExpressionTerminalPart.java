package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public abstract class ExpressionTerminalPart {
	public abstract boolean parse(PriorityQueue<Lexeme> lexemes);

}
