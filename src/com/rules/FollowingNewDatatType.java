package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class FollowingNewDatatType extends FollowingNew {
	public DataType dataType;
	public Expression expr;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		dataType = new DataType();
		if(!dataType.parse(lexemes))
			return false;
		Lexeme l = lexemes.peek();
		
		
		if(l!=null&&l.relatedToken.name.equals("LEFT_SQUARE_B")) {
			poped.add(lexemes.poll());
			expr = new Expression();
			if(!expr.parse(lexemes))
				return false;
			l = lexemes.peek();
			if(l!=null&&l.relatedToken.name.equals("RIGHT_SQUARE_B")) {
				lexemes.poll();
				return true;
			}
		}
		Utils.RollBack(lexemes, poped);
		return false;
	}

	@Override
	public void print() {
		dataType.print();
		System.out.print("[");
		expr.print();
		System.out.print("]");
		
	}
	
	
	
}
