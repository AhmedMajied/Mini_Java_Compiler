package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Expression {
	public ExpressionTerminalPart exprTerminal;
	public ExpressionDash exprDash;
	
	public boolean parse(PriorityQueue<Lexeme> lexemes) {
		exprTerminal= new IntExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)) {
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new FloatExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)) {
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new TrueExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new FalseExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new IdentifierExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new ThisExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}

		exprTerminal= new NewExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new NotExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}
		exprTerminal= new BracketExpressionTerminalPart();
		if(exprTerminal.parse(lexemes)){
			parseExpressionDash(lexemes);
			return true;
		}
		return false;
		
	}
	private void parseExpressionDash(PriorityQueue<Lexeme> lexemes) {
		exprDash = new OperatorExpressionDash();
		if(exprDash.parse(lexemes))
			return;
		exprDash = new ExpressionExpressionDash();
		if(exprDash.parse(lexemes))
			return;
		exprDash = new DotExpressionDash();
		exprDash.parse(lexemes);
	}
}
