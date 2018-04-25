package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class FollowingNewIdentifier extends FollowingNew{
	public Identifier identifier;
	public ArrayList<Expression> exprs;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		exprs=new ArrayList<>();
		identifier = new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		Lexeme l = lexemes.peek();
		if(l!=null&&l.relatedToken.name.equals("LEFT_ROUND_B")) {
			poped.add(lexemes.poll());
			Expression expr = new Expression();
			while(expr.parse(lexemes)) {
				exprs.add(expr);
				if(lexemes.peek().relatedToken.name.equals("COMMA"))
					poped.add(lexemes.poll());
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
