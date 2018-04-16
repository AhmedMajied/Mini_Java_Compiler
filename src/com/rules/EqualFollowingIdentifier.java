package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class EqualFollowingIdentifier extends FollowingIdentifier {
	public Expression expr;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("ASSIGNMENT"))
			return false;
		lexemes.poll();
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
			return false;
		lexemes.poll();
		return true;
	}
}
