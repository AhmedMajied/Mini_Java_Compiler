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
				if(exprDash.parse(lexemes))
					return true;
				else {
					exprDash = new ExpressionExpressionDash();
					if(exprDash.parse(lexemes)) {
						return true;
					}
					else {
						exprDash = new DotExpressionDash();
						if(exprDash.parse(lexemes)) {
							return true;
						}
						else {
							exprDash = null;
							return true;
							
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public void print() {
		operator.print();
		System.out.print(" ");
		expr.print();
		System.out.print(" ");
		if(exprDash!=null)
		{
			exprDash.print();
			System.out.print(" ");
		}
	}
}
