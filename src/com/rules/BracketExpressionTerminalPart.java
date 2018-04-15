package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class BracketExpressionTerminalPart extends ExpressionTerminalPart{
	public Expression expr;
	

	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if (l.relatedToken.name.equals("LEFT_ROUND_B")) {
			lexemes.poll();
			expr=new Expression();
			if(expr.parse(lexemes)) {
				l = lexemes.peek();
				if (l.relatedToken.name.equals("RIGHT_ROUND_B")) {
					lexemes.poll();
					return true;
				}
			}
		}
		return false;
	}
}
