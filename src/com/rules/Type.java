package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Type {
	public DataType type;
	public ArrayBrackets arrayBrackets;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		type=new DataType();
		arrayBrackets=new ArrayBrackets();
		if(!type.parse(lexemes))
			return false;
		arrayBrackets.parse(lexemes);
		return true;
	}
}
