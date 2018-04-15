package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Expression {
	public ExpressionTerminalPart exprTerminal;
	public ExpressionDash exprDash;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		exprTerminal= new IntExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new FloatExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new TrueExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new FalseExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new IdentifierExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new ThisExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new NewExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new NotExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		exprTerminal= new BracketExpressionTerminalPart();
		if(exprTerminal.parse(lexemes))
			return parseExpressionDash(lexemes);
		return false;
		
	}
	private boolean parseExpressionDash(PriorityQueue<Lexeme> lexemes) {
		exprDash = new OperatorExpressionDash();
		if(exprDash.parse(lexemes))
			return true;
		exprDash = new ExpressionExpressionDash();
		if(exprDash.parse(lexemes))
			return true;
		exprDash = new DotExpressionDash();
		if(exprDash.parse(lexemes))
			return true;
		return false;
	}
}
