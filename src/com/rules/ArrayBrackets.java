package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class ArrayBrackets {
	public boolean isEmpty;
	
	public void parse(PriorityQueue<Lexeme>lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_SQUARE_B")){
			isEmpty=true;
			return;
		}
		lexemes.poll();
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_SQUARE_B")){
			isEmpty=true;
			return;
		}
		lexemes.poll();
		
		isEmpty=false;
	}
}
