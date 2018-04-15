package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class NewExpressionTerminalPart extends ExpressionTerminalPart {
	public FollowingNew followingNew;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l.relatedToken.name.equals("NEW")) {
			lexemes.poll();
			followingNew=new FollowingNewDatatType();
			if(followingNew.parse(lexemes))
				return true;
			else {
				followingNew=new FollowingNewIdentifier();
				if(followingNew.parse(lexemes))
					return true;
			}
		}

		return false;
	}
}
