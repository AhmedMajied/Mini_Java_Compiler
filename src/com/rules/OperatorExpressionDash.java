package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class OperatorExpressionDash extends ExpressionDash {
	public Operator operator;
	public Expression expr;
	public ExpressionDash exprDash;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		operator=new Operator();
		if(operator.parse(lexemes)) {
			expr=new Expression();
			if(expr.parse(lexemes)) {
				exprDash = new OperatorExpressionDash();
				if(expr.parse(lexemes))
					return true;
				else {
					exprDash = new ExpressionExpressionDash();
					if(expr.parse(lexemes)) {
						return true;
					}
					else {
						exprDash = new DotExpressionDash();
						if(expr.parse(lexemes)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
