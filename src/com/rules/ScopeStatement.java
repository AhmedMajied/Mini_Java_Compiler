package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class ScopeStatement extends Statement {
	public ArrayList<Statement> stmts;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {

		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_CURLY_B"))
			return false;
		poped.add(lexemes.poll());
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
		if(l==null||!l.relatedToken.name.equals("RIGHT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		lexemes.poll();
		return true;
	}

	@Override
	public void print() {
		System.out.print("{\r\n");
		for(Statement st : stmts) {
			st.print();
			System.out.print("\r\n");
		}
		System.out.print("}\r\n");

	}
	
}
