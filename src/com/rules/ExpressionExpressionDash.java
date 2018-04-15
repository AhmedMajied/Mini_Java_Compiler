package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class ExpressionExpressionDash extends ExpressionDash {
	public Expression expr;
	public ExpressionDash exprDash;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();

		if (!l.relatedToken.name.equals("LEFT_SQUARE_B"))
			return false;
		lexemes.poll();
		expr = new Expression();
		if (!expr.parse(lexemes))
			return false;
		exprDash = new OperatorExpressionDash();
		if (!expr.parse(lexemes)) {
			exprDash = new ExpressionExpressionDash();
			if (!expr.parse(lexemes)) {
				exprDash = new DotExpressionDash();
				if (!expr.parse(lexemes)) {
					exprDash = null;
				}
			}
		}
		l = lexemes.peek();
		if (!l.relatedToken.name.equals("RIGHT_SQUARE_B")) {
			return false;
		}
		lexemes.poll();

		return true;
	}
}
