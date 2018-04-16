package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class MethodDeclaration {
	public DataPrivacy privacy;
	public Type type;
	public Identifier identifier;
	public ArrayList<MethodParameter>params;
	public ArrayList<VarDeclaration> vars;
	public ArrayList<Statement> stmts;
	public Expression retExpr;
	
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		privacy= new DataPrivacy();
		if(!privacy.parse(lexemes))
			return false;
		
		type= new Type();
		if(!type.parse(lexemes))
			return false;
		
		identifier = new Identifier();
		if(!identifier.parse(lexemes))
			return false;
		
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_ROUND_B"))
			return false;
		
		params=new ArrayList<>();
		
		do {
			lexemes.poll();
			MethodParameter param = new MethodParameter();
			if(!param.parse(lexemes))
				break;
			params.add(param);
			l = lexemes.peek();
		}
		while(l!=null&&l.relatedToken.name.equals("COMMA"));
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_ROUND_B"))
			return false;
		lexemes.poll();

		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_CURLY_B"))
			return false;
		lexemes.poll();

		vars = new ArrayList<>();
		VarDeclaration var = new VarDeclaration();
		while(var.parse(lexemes))
			vars.add(var);
		
		
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
		if(l==null||!l.relatedToken.name.equals("RETURN"))
			return false;
		lexemes.poll();
		
		retExpr = new Expression();
		if(!retExpr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_CURLY_B"))
			return false;
		lexemes.poll();
		
		return true;
		
	}
		

}
