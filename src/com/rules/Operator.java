package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Operator {
	public String operator;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();

		if(l!=null&&(l.relatedToken.name.equals("PLUS")
				||l.relatedToken.name.equals("MINUS")
				||l.relatedToken.name.equals("MULTIPLY")
				||l.relatedToken.name.equals("DIV")
				||l.relatedToken.name.equals("AND")
				||l.relatedToken.name.equals("OR"))
				||l.relatedToken.name.equals("GREATER_EQ")
				||l.relatedToken.name.equals("LESS_EQ")
				||l.relatedToken.name.equals("NOT_EQUAL")
				||l.relatedToken.name.equals("EQUAL")				
				) {
			lexemes.poll();
			operator=l.matchedWord;
			return true;
		}
		return false;
	}
	
	public void print() {
		System.out.print(" "+operator);
	}

}
