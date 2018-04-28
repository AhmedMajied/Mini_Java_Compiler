package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class FollowingDotLength extends FollowingDot {
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped =  new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("DOT"))
			return false;
		poped.add(lexemes.poll());
		l=lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("LENGTH")) {
			lexemes.poll();
			return true;
		}
		Utils.RollBack(lexemes, poped);
		return false;
	}

	@Override
	public void print() {
		System.out.print("length");
		
	}
}
