package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class IdentifierStatement extends Statement{
	public Identifier identifier;
	public FollowingIdentifier followingIdentitifer;
	
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		identifier=new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		followingIdentitifer=new EqualFollowingIdentifier();
		if(followingIdentitifer.parse(lexemes))
			return true;
		followingIdentitifer=new BracketFollowingIdentifier();
		if(followingIdentitifer.parse(lexemes))
			return true;
		
		return false;
	}
}
