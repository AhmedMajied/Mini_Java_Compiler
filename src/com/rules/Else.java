package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Else {
	public Statement stmt;
	public boolean isEmpty;
	
	public void parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("ELSE")){
			isEmpty = true;
		}
		else {
			lexemes.poll();
			stmt = new ScopeStatement();
			if(!stmt.parse(lexemes)) {
				isEmpty = true;
				return;
			}
			stmt = new IfStatement();
			if(!stmt.parse(lexemes)) {
				isEmpty = true;
				return;
			}
			stmt = new WhileStatement();
			if(!stmt.parse(lexemes)) {
				isEmpty = true;
				return;
			}
			stmt = new PrintStatement();
			if(!stmt.parse(lexemes)) {
				isEmpty = true;
				return;
			}
			stmt = new IdentifierStatement();
			if(!stmt.parse(lexemes)) {
				isEmpty = true;
				return;
			}
		}
		isEmpty=false;
	}
}
