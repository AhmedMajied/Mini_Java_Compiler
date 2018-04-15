package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class ThisExpressionTerminalPart extends ExpressionTerminalPart{
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if (l.relatedToken.name.equals("THIS")) {
			lexemes.poll();
			return true;
		}

		return false;
	}
}
