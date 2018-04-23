package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class NewExpressionTerminalPart extends ExpressionTerminalPart {
	public FollowingNew followingNew;
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme>poped=new ArrayList<Lexeme>();
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("NEW")) {
			poped.add(lexemes.poll());
			followingNew=new FollowingNewDatatType();
			if(followingNew.parse(lexemes))
				return true;
			else {
				followingNew=new FollowingNewIdentifier();
				if(followingNew.parse(lexemes))
					return true;
			}
		}
		Utils.RollBack(lexemes, poped);
		return false;
	}
}
