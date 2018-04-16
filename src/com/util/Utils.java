package com.util;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.analyzer.Lexeme;

public class Utils {
	public static void RollBack(PriorityQueue<Lexeme>lexemes,ArrayList<Lexeme>poped) {
		for(Lexeme l : poped)
			lexemes.add(l);
	}
}
