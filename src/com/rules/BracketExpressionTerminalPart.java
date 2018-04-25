package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class BracketExpressionTerminalPart extends ExpressionTerminalPart{
	public Expression expr;
	

	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme>poped=new ArrayList<Lexeme>(); 
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("LEFT_ROUND_B")) {
			poped.add(lexemes.poll());
			expr=new Expression();
			if(expr.parse(lexemes)) {
				l = lexemes.peek();
				if (l!=null&&l.relatedToken.name.equals("RIGHT_ROUND_B")) {
					lexemes.poll();
					return true;
				}
			}
		}
		Utils.RollBack(lexemes, poped);
		return false;
	}
	
	public void print() {
		System.out.print("(");
		expr.print();
		System.out.print(")");
	}
}
