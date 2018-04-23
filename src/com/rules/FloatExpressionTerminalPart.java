package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class FloatExpressionTerminalPart extends ExpressionTerminalPart {
	public float number;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {

		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("FLOAT_LITERAL")) {
			lexemes.poll();
			number=Float.parseFloat(l.matchedWord);
			return true;
		}

		return false;
	}
}
