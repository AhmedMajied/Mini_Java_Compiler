package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class ClassDeclaration {
	public Identifier classIdentifier;
	public Identifier extendsIdentifier;
	public ArrayList<VarDeclaration> props;
	public ArrayList<ConstructorDeclaration> contructors;
	public ArrayList<MethodDeclaration> methods;
	
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {

		ArrayList<Lexeme>poped=new ArrayList<Lexeme>();
		Lexeme l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("CLASS"))
			return false;
		poped.add(lexemes.poll());
		classIdentifier=new Identifier();
		if(!classIdentifier.parse(lexemes))
			return false;
		l = lexemes.peek();
		if(l!=null&&l.relatedToken.name.equals("EXTENDS")){
			poped.add(lexemes.poll());
			extendsIdentifier=new Identifier();
			if(!extendsIdentifier.parse(lexemes)){
				Utils.RollBack(lexemes, poped);
				return false;
			}
		}

		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("LEFT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		poped.add(lexemes.poll());
		
		VarDeclaration var = new VarDeclaration();
		props = new ArrayList<>();
		while(var.parse(lexemes))
			props.add(var);
		
		contructors=new ArrayList<>();
		ConstructorDeclaration constructor = new ConstructorDeclaration();
		while(constructor.parse(lexemes))
			contructors.add(constructor);
		

		methods = new ArrayList<>();
		MethodDeclaration method = new MethodDeclaration();
		while(method.parse(lexemes))
			methods.add(method);
		l = lexemes.peek();
		if(l==null||!l.relatedToken.name.equals("RIGHT_CURLY_B"))
		{
			Utils.RollBack(lexemes, poped);
			return false;
		}
		lexemes.poll();



		return true;
	}
	
	
}
