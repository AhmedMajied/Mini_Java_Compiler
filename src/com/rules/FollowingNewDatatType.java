package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class FollowingNewDatatType extends FollowingNew {
	public DataType dataType;
	public Expression expr;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		dataType = new DataType();
		if(!dataType.parse(lexemes))
			return false;
		Lexeme l = lexemes.peek();
		if(l==null)
			return false;
		
		if(l.relatedToken.name.equals("LEFT_SQUARE_B")) {
			lexemes.poll();
			expr = new Expression();
			if(!expr.parse(lexemes))
				return false;
			l = lexemes.peek();
			if(l.relatedToken.name.equals("RIGHT_SQUARE_B")) {
				lexemes.poll();
				return true;
			}
		}
		
		return false;
	}
}
