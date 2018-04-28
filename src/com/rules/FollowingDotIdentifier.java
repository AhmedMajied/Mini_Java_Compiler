package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class FollowingDotIdentifier extends FollowingDot{
	public Identifier identifier;
	public ArrayList<Expression> exprs;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		if(lexemes.isEmpty())
			return false;
		exprs=new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("DOT"))
			return false;
		poped.add(lexemes.poll());
		identifier = new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		
		l = lexemes.peek();
	
		if(l!=null&&l.relatedToken.name.equals("LEFT_ROUND_B")) {
			poped.add(lexemes.poll());
			Expression expr = new Expression();
			while(expr.parse(lexemes)) {
				exprs.add(expr);
				l=lexemes.peek();
				if(l!=null&&l.relatedToken.name.equals("COMMA"))
					poped.add(lexemes.poll());
				else break;
			}
			l = lexemes.peek();

			if(l!=null&&l.relatedToken.name.equals("RIGHT_ROUND_B")) {

				lexemes.poll();
				return true;
			}
		}
		Utils.RollBack(lexemes, poped);
		return false;
	}

	@Override
	public void print() {
		identifier.print();
		System.out.print("(");
		for(int i=0;i<exprs.size();++i) {
			if(i>0)
				System.out.print(", ");
			exprs.get(i).print();
		}
		System.out.print(")");
		
	}
}
