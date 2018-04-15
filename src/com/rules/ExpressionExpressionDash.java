package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class ExpressionExpressionDash extends ExpressionDash {
	public Expression expr;
	public ExpressionDash exprDash;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if (l.relatedToken.name.equals("LEFT_SQUARE_B")) {
			expr = new Expression();
			if (expr.parse(lexemes)) {
				l = lexemes.peek();
				if (l.relatedToken.name.equals("RIGHT_SQUARE_B")) {
					exprDash = new OperatorExpressionDash();
					if (expr.parse(lexemes))
						return true;
					else {
						exprDash = new ExpressionExpressionDash();
						if (expr.parse(lexemes)) {
							return true;
						} else {
							exprDash = new DotExpressionDash();
							if (expr.parse(lexemes)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
