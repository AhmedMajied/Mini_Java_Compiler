package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class MethodParameter {
	public Type type;
	public Identifier identifier;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		type= new Type();
		if(!type.parse(lexemes))
			return false;
		identifier = new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		
		return true;
	}
}
