package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class NotExpressionTerminalPart extends ExpressionTerminalPart{
	public Expression expr;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("NOT")) {
			lexemes.poll();
			expr=new Expression();
			return expr.parse(lexemes);
		}
		return false;
	}
}
