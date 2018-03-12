import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalysis {
	private Vector<Token> Tokens = new Vector<Token>();
	
	public LexicalAnalysis(){
		createTokens();
	}
	
	public void extractTokens(String text){
		Set<Lexeme> Lexemes = new TreeSet<>();
		Pattern pattern;
		Matcher matcher;
		
		for(int i=0;i<Tokens.size();i++){
			pattern = Pattern.compile(Tokens.get(i).pattern);
			matcher = pattern.matcher(text);
			
			while(matcher.find()){
				Lexemes.add(new Lexeme(matcher.group(), matcher.start(), Tokens.get(i)));
				text = text.replace(matcher.group(), repeatSpaces(matcher.group().length()));
			}
		}
		
		// for testing only
		for(Lexeme l : Lexemes) {
			System.out.println(l.matchedWord);
		}
		
	}
	
	public void createTokens(){
		
		// you should add here your tokens with its suitable order 
		// ( i guess that all will be after mine
		Tokens.add(new Token("M_COMMENTS","-	\\/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*\\/"));
		Tokens.add(new Token("S_COMMENTS","\\/\\/.*\\n"));
		Tokens.add(new Token("STRING_LITERAL","\".*\""));
		
		Tokens.add(new Token("SYSTEM.OUT.PRINTLN","System.out.println"));
		Tokens.add(new Token("IF","if"));
		Tokens.add(new Token("INT","int"));
		Tokens.add(new Token("ELSE","else"));
		Tokens.add(new Token("MAIN","main"));
		Tokens.add(new Token("THIS","this"));
		Tokens.add(new Token("TRUE","true"));
		Tokens.add(new Token("VOID","void"));
		Tokens.add(new Token("CLASS","class"));
		Tokens.add(new Token("FALSE","false"));
		Tokens.add(new Token("WHILE","while"));
		Tokens.add(new Token("LENGTH","length"));
		Tokens.add(new Token("PUBLIC","public"));
		Tokens.add(new Token("PRIVATE","private"));
		Tokens.add(new Token("PROTECTED","protected"));
		Tokens.add(new Token("RETURN","return"));
		Tokens.add(new Token("STATIC","static"));
		Tokens.add(new Token("NEW","new"));
		Tokens.add(new Token("STRING","string"));
		Tokens.add(new Token("FLOAT","float"));
		Tokens.add(new Token("CHARACTER","char"));
		Tokens.add(new Token("BOOLEAN","boolean"));
		Tokens.add(new Token("EXTENDS","extends"));
		Tokens.add(new Token("NULL","null"));
		Tokens.add(new Token("ABSTRACT","abstract"));
		Tokens.add(new Token("ASSERT","assert"));
		Tokens.add(new Token("BREAK","break"));
		Tokens.add(new Token("CONTINUE","continue"));
		Tokens.add(new Token("BYTE","byte"));
		Tokens.add(new Token("CASE","case"));
		Tokens.add(new Token("CATCH","catch"));
		Tokens.add(new Token("CONST","const"));
		Tokens.add(new Token("DEFAULT","default"));
		Tokens.add(new Token("DO","do"));
		Tokens.add(new Token("DOUBLE","double"));
		Tokens.add(new Token("ENUM","ENUM"));
		Tokens.add(new Token("FINAL","final"));
		Tokens.add(new Token("FINALY","finaly"));
		Tokens.add(new Token("FOR","for"));
		Tokens.add(new Token("GOTO","goto"));
		Tokens.add(new Token("IMPLEMENTS","implements"));
		Tokens.add(new Token("IMPORT","import"));
		Tokens.add(new Token("INSTANCEOF","instanceof"));
		Tokens.add(new Token("INTERFACE","interface"));
		Tokens.add(new Token("SHORT","short"));
		Tokens.add(new Token("SUPER","super"));
		Tokens.add(new Token("SWITCH","switch"));
		Tokens.add(new Token("THROW","throw"));
		Tokens.add(new Token("TRY","try"));
		
		//Andrew
		Tokens.add(new Token("EOL","$"));
		Tokens.add(new Token("PLUS","\\+"));
		Tokens.add(new Token("COMMA",","));
		Tokens.add(new Token("DOT","\\."));
		Tokens.add(new Token("NOT","\\!"));
		Tokens.add(new Token("EQUAL","="));
		Tokens.add(new Token("SEMICOLON",";"));
		Tokens.add(new Token("AND","&&"));
		Tokens.add(new Token("MINUS","\\-"));
		Tokens.add(new Token("MULTIPLY","\\*"));
		Tokens.add(new Token("LESSTHAN","<"));
		Tokens.add(new Token("GREATERTHAN",">"));
		
		
		Tokens.add(new Token("LEFT_CURLY_B","\\{"));
		Tokens.add(new Token("RIGHT_CURLY_B","\\}"));
		Tokens.add(new Token("LEFT_SQUARE_B","\\["));
		Tokens.add(new Token("RIGHT_SQUARE_B","\\]"));
		Tokens.add(new Token("LEFT_ROUND_B","\\("));
		Tokens.add(new Token("RIGHT_ROUND_B","\\)"));
		
		//This Should be the Last Token to be Checked
		Tokens.add(new Token("ERROR","\\S"));

		
	}
	
	private String repeatSpaces(int times) {
        return new String(new char[times]).replace("\0", " ");
    }
}
