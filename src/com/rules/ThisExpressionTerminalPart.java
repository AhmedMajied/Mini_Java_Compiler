package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class ThisExpressionTerminalPart extends ExpressionTerminalPart{
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		if(lexemes.isEmpty())
			return false;
		Lexeme l = lexemes.peek();
		if (l!=null&&l.relatedToken.name.equals("THIS")) {
			lexemes.poll();
			return true;
		}

		return false;
	}

	@Override
	public void print() {
		System.out.print("this");
		
	}
}
