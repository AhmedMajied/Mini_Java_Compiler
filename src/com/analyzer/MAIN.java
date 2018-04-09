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

public class MAIN {
	public static void main(String[] args) throws IOException {
		String input = new String(Files.readAllBytes(Paths.get("input.txt")), StandardCharsets.UTF_8);
		StringBuffer text = new StringBuffer(input);
		PriorityQueue<Lexeme> Lexemes = LexicalAnalyser.extractTokens(text);
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		while(!Lexemes.isEmpty()) {
			Lexeme l = Lexemes.poll();
			writer.println("< " + l.relatedToken.name + " > : " + ((l.relatedToken.name.equals("EOL"))?"End Of Line":l.matchedWord));
		}
		writer.close();
	}
}
