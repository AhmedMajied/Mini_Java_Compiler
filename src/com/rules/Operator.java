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
				) {
			lexemes.poll();
			operator=l.matchedWord;
			return true;
		}
		
		else if(l!=null&&(l.relatedToken.name.equals("GREATERTHAN")||l.relatedToken.name.equals("LESSTHAN"))) {
			lexemes.poll();
			operator=l.matchedWord;
			l = lexemes.peek();
			if(l!=null&&l.relatedToken.name.equals("EQUAL")) {
				operator+=l.matchedWord;
				lexemes.poll();
			}
			return true;
		}
		else if(l!=null&&l.relatedToken.name.equals("NOT")) {
			Lexeme l2 = lexemes.peek();
			if(l2!=null&&l2.relatedToken.name.equals("EQUAL"))
				lexemes.poll();
				lexemes.poll();
				operator=l.matchedWord;
				operator+=l2.matchedWord;
			return true;
		}
		return false;
	}
	
	public void print() {
		System.out.print(operator);
	}

}
