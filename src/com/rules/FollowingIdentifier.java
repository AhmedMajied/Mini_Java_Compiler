package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public abstract class FollowingIdentifier {
	public abstract boolean parse(PriorityQueue<Lexeme> lexemes);
}
