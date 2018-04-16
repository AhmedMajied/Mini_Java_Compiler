package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class BracketFollowingIdentifier extends FollowingIdentifier {
	public Expression b_expr;
	public Expression e_expr;
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_SQUARE_B"))
			return false;
		lexemes.poll();
		
		b_expr=new Expression();
		if(!b_expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_SQUARE_B"))
			return false;
		lexemes.poll();

		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("ASSIGNMENT"))
			return false;
		lexemes.poll();
		
		e_expr=new Expression();
		if(!e_expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
			return false;
		lexemes.poll();
		
		return true;
	}
}
