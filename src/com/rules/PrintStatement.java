package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class PrintStatement extends Statement{
	public Expression expr;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SYSTEM.OUT.PRINTLN"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_ROUND_B"))
			return false;
		lexemes.poll();
		
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_ROUND_B"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
			return false;
		lexemes.poll();
		
		return true;
	}
}
