package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class DataPrivacy {
	public String privacy;

	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null||(!l.relatedToken.name.equals("PRIVATE") 
				&& !l.relatedToken.name.equals("PUBLIC")
				&& !l.relatedToken.name.equals("PROTECTED")))
		{
			return false;
		}
		privacy=l.matchedWord;
		lexemes.poll();
		return true;
	}
	
	public void print() {
			System.out.print(privacy+" ");
	}
}
