package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class PrintStatement extends Statement{
	public Expression expr;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SYSTEM.OUT.PRINTLN"))
			return false;
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_ROUND_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_ROUND_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		lexemes.poll();
		
		return true;
	}
}
