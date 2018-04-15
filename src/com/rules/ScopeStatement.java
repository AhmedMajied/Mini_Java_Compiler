package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class ScopeStatement extends Statement {
	public ArrayList<Statement> stmts;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(!l.relatedToken.name.equals("LEFT_CURLY_B"))
			return false;
		lexemes.poll();
		stmts = new ArrayList<>();
		boolean isParsed = true;
		
		while(isParsed) {
			Statement st = new ScopeStatement();
			if(st.parse(lexemes)) {
				stmts.add(st);
				continue;
			}
			st = new IfStatement();
			if(st.parse(lexemes)) {
				stmts.add(st);
				continue;
			}
			st = new WhileStatement();
			if(st.parse(lexemes)) {
				stmts.add(st);
				continue;
			}
			st = new PrintStatement();
			if(st.parse(lexemes)) {
				stmts.add(st);
				continue;
			}
			st = new IdentifierStatement();
			if(st.parse(lexemes)) {
				stmts.add(st);
				continue;
			}
			isParsed=false;
		}
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("RIGHT_CURLY_B"))
			return false;
		lexemes.poll();
		return true;
	}
}
