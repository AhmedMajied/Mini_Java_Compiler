package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class DotExpressionDash extends ExpressionDash {
	public FollowingDot followingDot;
	public ExpressionDash expr;
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("DOT")) {
			followingDot = new FollowingDotLength();
			if (!followingDot.parse(lexemes)) {
				followingDot = new FollowingDotIdentifier();
				if (!followingDot.parse(lexemes))
					return false;
			}

			expr = new OperatorExpressionDash();
			if (expr.parse(lexemes))
				return true;
			else {
				expr = new ExpressionExpressionDash();
				if (expr.parse(lexemes)) {
					return true;
				} else {
					expr = new DotExpressionDash();
					if (expr.parse(lexemes)) {
						return true;
					}
					else {
						expr = null;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void print() {
		System.out.print(".");
		followingDot.print();
		if(expr!=null)
			expr.print();
	}
}










