package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class MainClass {
	public Identifier classIdentifier;
	public Identifier argsIdentifier;
	public Statement stmt;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("CLASS"))
			return false;
		poped.add(lexemes.poll());
		
		classIdentifier=new Identifier();
		if(!classIdentifier.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("PUBLIC"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("STATIC"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("VOID"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("MAIN"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_ROUND_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("STRING"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_SQUARE_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_SQUARE_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		argsIdentifier=new Identifier();
		if(!argsIdentifier.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_ROUND_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		stmt = new ScopeStatement();
		if(!stmt.parse(lexemes)){
			stmt = new IfStatement();
			if(!stmt.parse(lexemes)){
				stmt = new WhileStatement();
				if(!stmt.parse(lexemes)){
					stmt = new PrintStatement();
					if(!stmt.parse(lexemes)){
						stmt = new IdentifierStatement();
						if(!stmt.parse(lexemes)){
							Utils.RollBack(lexemes, poped);
							return false;
						}
					}
					
				}
				
			}
			
		}
		

		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		
		lexemes.poll();
		
		return true;
		
		
	}

	public void print() {
		System.out.print("class ");
		classIdentifier.print();
		System.out.print("{\r\npublic static void main(String []");
		argsIdentifier.print();
		System.out.print("){\r\n");
		stmt.print();
		System.out.print("\r\n}\r\n}\r\n");
		
	}

}
