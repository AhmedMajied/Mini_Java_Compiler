package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Goal {
	public MainClass main;
	public ArrayList<ClassDeclaration> classDeclarations;
	
	public boolean parse(PriorityQueue<Lexeme>lexemes) {
		main = new MainClass();
		if(!main.parse(lexemes))
			return false;
		ClassDeclaration classDeclaration = new ClassDeclaration();
		classDeclarations=new ArrayList<>();
		while(classDeclaration.parse(lexemes))
			classDeclarations.add(classDeclaration);
		return true;
	}
}
