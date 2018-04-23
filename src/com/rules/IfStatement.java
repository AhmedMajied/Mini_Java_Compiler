package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class IfStatement extends Statement{
	public Expression expr;
	public Statement stmt;
	public Else _else;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("IF"))
			return false;
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_ROUND_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_ROUND_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		_else = new Else();
		
		stmt = new ScopeStatement();
		if(stmt.parse(lexemes)){
			_else.parse(lexemes);
			return true;
		}
		stmt = new IfStatement();
		if(stmt.parse(lexemes)){
			_else.parse(lexemes);
			return true;
		}
		stmt = new WhileStatement();
		if(stmt.parse(lexemes)){
			_else.parse(lexemes);
			return true;
		}
		stmt = new PrintStatement();
		if(stmt.parse(lexemes)){
			_else.parse(lexemes);
			return true;
		}
		stmt = new IdentifierStatement();
		if(stmt.parse(lexemes)){
			_else.parse(lexemes);
			return true;
		}
		Utils.RollBack(lexemes, poped);
		return false;
	}
}












