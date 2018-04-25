package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class DataType {
	public String dataType;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null)
			return false;

		if(l!=null&&(l.relatedToken.name.equals("INT")
				||l.relatedToken.name.equals("FLOAT")
				||l.relatedToken.name.equals("STRING")
				||l.relatedToken.name.equals("CHAR")
				||l.relatedToken.name.equals("BOOLEAN")
				)) {
			lexemes.poll();
			dataType=l.matchedWord;
			return true;
		}		
		return false;
	}
	
	public void print() {
		System.out.print(dataType+" ");
	}
}
