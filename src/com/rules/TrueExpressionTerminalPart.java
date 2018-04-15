package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class TrueExpressionTerminalPart extends ExpressionTerminalPart{
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l.relatedToken.name.equals("TRUE")) {
			lexemes.poll();
			return true;
		}

		return false;
	}
}
