package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class WhileStatement extends Statement{
	public Expression expr;
	public Statement stmt;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		Lexeme l = lexemes.peek();
		if(!l.relatedToken.name.equals("WHILE"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("LEFT_ROUND_B"))
			return false;
		lexemes.poll();
		
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("RIGHT_ROUND_B"))
			return false;
		lexemes.poll();
				
		stmt = new ScopeStatement();
		if(stmt.parse(lexemes)){
			return true;
		}
		stmt = new IfStatement();
		if(stmt.parse(lexemes)){
			return true;
		}
		stmt = new WhileStatement();
		if(stmt.parse(lexemes)){
			return true;
		}
		stmt = new PrintStatement();
		if(stmt.parse(lexemes)){
			return true;
		}
		stmt = new IdentifierStatement();
		if(stmt.parse(lexemes)){
			return true;
		}
		
		return false;
	}
}
