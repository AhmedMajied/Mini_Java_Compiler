package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class WhileStatement extends Statement{
	public Expression expr;
	public Statement stmt;
	
	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();// This will contain the poped items from priority queue
		
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("WHILE")) 
			return false;
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_ROUND_B")) {
			Utils.RollBack(lexemes, poped); // This will return poped elements back into priority queue
			return false;
		}
		poped.add(lexemes.poll());
		
		expr=new Expression();
		if(!expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_ROUND_B")){
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
				
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
		
		Utils.RollBack(lexemes, poped);
		return false;
	}
}
