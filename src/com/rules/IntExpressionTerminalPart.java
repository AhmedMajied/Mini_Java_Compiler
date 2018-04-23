package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class IntExpressionTerminalPart extends ExpressionTerminalPart {
	public int number;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("INTEGRAL_LITERAL")) {
			lexemes.poll();
			number=Integer.parseInt(l.matchedWord);
			return true;
		}

		return false;
	}
}
