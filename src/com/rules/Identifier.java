package com.rules;

import java.util.PriorityQueue;
import java.util.Set;

import com.analyzer.Lexeme;

public class Identifier {
	public String id;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l.relatedToken.name.equals("ID")) {
			lexemes.poll();
			id=l.matchedWord;
			return true;
		}
		return false;
	}
	
}
