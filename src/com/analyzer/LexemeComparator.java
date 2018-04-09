package com.analyzer;

import java.util.Comparator;

public class LexemeComparator implements Comparator<Lexeme>{

	@Override
	public int compare(Lexeme o1, Lexeme o2) {
		return o1.startIndex-o2.startIndex;
	}

}
