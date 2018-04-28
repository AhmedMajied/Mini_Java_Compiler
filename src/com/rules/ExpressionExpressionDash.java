package com.rules;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;
import com.util.Utils;

public class ExpressionExpressionDash extends ExpressionDash {
	public Expression expr;
	public ExpressionDash exprDash;

	@Override
	public boolean parse(PriorityQueue<Lexeme> lexemes) {

		ArrayList<Lexeme> poped = new ArrayList<>();
		Lexeme l = lexemes.peek();

		if (l==null||!l.relatedToken.name.equals("LEFT_SQUARE_B"))
			return false;
		poped.add(lexemes.poll());
		expr = new Expression();
		if (!expr.parse(lexemes))
			return false;
		
		l = lexemes.peek();
		if (l==null||!l.relatedToken.name.equals("RIGHT_SQUARE_B")) {
			Utils.RollBack(lexemes, poped);
			return false;
		}
		lexemes.poll();
		
		exprDash = new OperatorExpressionDash();
		if (!exprDash.parse(lexemes)) {
			exprDash = new ExpressionExpressionDash();
			if (!exprDash.parse(lexemes)) {
				exprDash = new DotExpressionDash();
				if (!exprDash.parse(lexemes)) {
					exprDash = null;
				}
			}
		}

		return true;
	}
	
	public void print() {
		System.out.print("[");
		expr.print();
		System.out.print("]");
		if(exprDash!=null)
			exprDash.print();
		
		
	}
}
