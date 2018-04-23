package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class IdentifierExpressionTerminalPart extends ExpressionTerminalPart{
	public Identifier identifier;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		identifier=new Identifier();
		return identifier.parse(lexemes);
	}
}
