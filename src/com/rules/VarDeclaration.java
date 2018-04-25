package com.rules;

import java.util.PriorityQueue;
import com.analyzer.Lexeme;

public class VarDeclaration {
	public Type type;
	public Identifier identifier;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		type= new Type();
		if(!type.parse(lexemes))
			return false;
		identifier = new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
			return false;
		lexemes.poll();
		return true;
	}

	public void print() {
		type.print();
		identifier.print();
		System.out.print(";\r\n");
		
	}
}
