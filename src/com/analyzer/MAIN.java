package com.analyzer;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.rules.BracketExpressionTerminalPart;
import com.rules.BracketFollowingIdentifier;
import com.rules.DataType;
import com.rules.EqualFollowingIdentifier;
import com.rules.Expression;
import com.rules.ExpressionTerminalPart;
import com.rules.FalseExpressionTerminalPart;
import com.rules.FloatExpressionTerminalPart;
import com.rules.FollowingDot;
import com.rules.FollowingDotIdentifier;
import com.rules.FollowingDotLength;
import com.rules.FollowingIdentifier;
import com.rules.FollowingNew;
import com.rules.FollowingNewDatatType;
import com.rules.FollowingNewIdentifier;
import com.rules.Goal;
import com.rules.Identifier;
import com.rules.IdentifierStatement;
import com.rules.IfStatement;
import com.rules.IntExpressionTerminalPart;
import com.rules.NewExpressionTerminalPart;
import com.rules.NotExpressionTerminalPart;
import com.rules.Operator;
import com.rules.PrintStatement;
import com.rules.ScopeStatement;
import com.rules.Statement;
import com.rules.ThisExpressionTerminalPart;
import com.rules.TrueExpressionTerminalPart;
import com.rules.Type;
import com.rules.WhileStatement;

public class MAIN {
	public static void main(String[] args) throws IOException {
		String input = new String(Files.readAllBytes(Paths.get("input.txt")), StandardCharsets.UTF_8);
		StringBuffer text = new StringBuffer(input);
		PriorityQueue<Lexeme> Lexemes = LexicalAnalyser.extractTokens(text);
		Goal g = new Goal();
		
		System.setOut(new PrintStream(new File("output.txt"))); // Print to output.txt file
		
		if (g.parse(Lexemes)) {
			g.print();
		}
		else {
			System.out.print("Syntax Error !");
		}
	}
}
