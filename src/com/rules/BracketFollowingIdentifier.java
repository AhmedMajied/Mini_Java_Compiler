package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class BracketFollowingIdentifier extends FollowingIdentifier {
	public Expression b_expr;
	public Expression e_expr;
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();

		if(l==null||!l.relatedToken.name.equals("LEFT_SQUARE_B"))
			return false;
		poped.add(lexemes.poll());

		b_expr=new Expression();
		if(!b_expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_SQUARE_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("ASSIGNMENT"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		e_expr=new Expression();
		if(!e_expr.parse(lexemes))
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
		System.out.print("[");
		b_expr.print();
		System.out.print("] = ");
		e_expr.print();
		System.out.print(";");
	}
}








