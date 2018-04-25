package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class MethodDeclaration {
	public DataPrivacy privacy;
	public Type type;
	public Identifier identifier;
	public ArrayList<MethodParameter>params;
	public ArrayList<VarDeclaration> vars;
	public ArrayList<Statement> stmts;
	public Expression retExpr;
	
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		ArrayList<Lexeme> poped = new ArrayList<>();
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

			poped.add(lexemes.poll());
			MethodParameter param = new MethodParameter();
			if(!param.parse(lexemes))
				break;
			params.add(param);
			l = lexemes.peek();
		}
		while(l!=null&&l.relatedToken.name.equals("COMMA"));
		
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

		vars = new ArrayList<>();
		VarDeclaration var = new VarDeclaration();
		while(var.parse(lexemes))
			vars.add(var);
		
		
		boolean isParsed = true;
		stmts=new ArrayList<>();
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
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());

		retExpr = new Expression();
		if(!retExpr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("SEMICOLON"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		lexemes.poll();
		
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
		privacy.print();
		type.print();
		identifier.print();
		System.out.print("(");
		for(int i = 0;i<params.size();++i) {
			if(i>0)
				System.out.print(", ");
			params.get(i).print();
		}
		
		System.out.print(") {\r\n");
		for(VarDeclaration var : vars) {
			var.print();
			System.out.print("\r\n");
		}
		
		for(Statement st : stmts) {
			st.print();
			System.out.print("\r\n");
		}
		
		
		System.out.print("}\r\n");
		
	}
		

}
