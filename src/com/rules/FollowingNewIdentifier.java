package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class FollowingNewIdentifier extends FollowingNew{
	public Identifier identifier;
	public ArrayList<Expression> exprs;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		if(lexemes.isEmpty())
			return false;
		exprs=new ArrayList<>();
		identifier = new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		Lexeme l = lexemes.peek();
		if(l.relatedToken.name.equals("LEFT_ROUND_B")) {
			lexemes.poll();
			Expression expr = new Expression();
			while(expr.parse(lexemes)) {
				exprs.add(expr);
				if(lexemes.peek().relatedToken.name.equals("COMMA"))
					lexemes.poll();
			}
			l = lexemes.peek();
			if(l.relatedToken.name.equals("RIGHT_ROUND_B")) {
				lexemes.poll();
				return true;
			}
		}
		
		return false;
	}
}
