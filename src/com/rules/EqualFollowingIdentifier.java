package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class EqualFollowingIdentifier extends FollowingIdentifier {
	public Expression expr;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("ASSIGNMENT"))
			return false;
		poped.add(lexemes.poll());
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		lexemes.poll();
		return true;
	}
	
	public void print() {
		System.out.print("=");
		expr.print();
		System.out.print(";\r\n");
	}
}
