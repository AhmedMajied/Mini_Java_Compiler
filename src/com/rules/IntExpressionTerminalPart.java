package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class IntExpressionTerminalPart extends ExpressionTerminalPart {
	public int number;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if (l.relatedToken.name.equals("INTEGER")) {
			lexemes.poll();
			number=Integer.parseInt(l.matchedWord);
			return true;
		}

		return false;
	}
}
