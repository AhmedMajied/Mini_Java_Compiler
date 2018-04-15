package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class MainClass {
	public Identifier classIdentifier;
	public Identifier argsIdentifier;
	public Statement stmt;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {

		Lexeme l = lexemes.peek();
		if(!l.relatedToken.name.equals("CLASS"))
			return false;
		lexemes.poll();
		
		classIdentifier=new Identifier();
		if(!classIdentifier.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("LEFT_CURLY_B"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("PUBLIC"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("STATIC"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("VOID"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("MAIN"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("LEFT_ROUND_B"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("STRING"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("LEFT_SQUARE_B"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("RIGHT_SQUARE_B"))
			return false;
		lexemes.poll();
		
		argsIdentifier=new Identifier();
		if(!argsIdentifier.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("RIGHT_ROUND_B"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("LEFT_CURLY_B"))
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
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("RIGHT_CURLY_B"))
			return false;
		lexemes.poll();
		
		l = lexemes.peek();
		if(!l.relatedToken.name.equals("RIGHT_CURLY_B"))
			return false;
		lexemes.poll();
		
		return true;
		
		
	}

}
