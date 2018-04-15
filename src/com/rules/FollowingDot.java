package com.rules;

import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public abstract class FollowingDot {
	public abstract boolean parse(PriorityQueue<Lexeme>lexemes);
}
