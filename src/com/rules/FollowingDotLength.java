package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class FollowingDotLength extends FollowingDot {
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("LENGTH")) {
			lexemes.poll();
			return true;
		}

		return false;
	}
}
