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
	
	public void extractTokens(StringBuffer text){
		Set<Lexeme> Lexemes = new TreeSet<>();
		Pattern pattern;
		Matcher matcher;
		
		for(int i=0;i<Tokens.size();i++){
			pattern = Pattern.compile(Tokens.get(i).pattern);
			matcher = pattern.matcher(text);
			
			while(matcher.find()){
				Lexemes.add(new Lexeme(matcher.group(), matcher.start(), Tokens.get(i)));
				text.replace(matcher.start(),matcher.group().length()+matcher.start(), 
							repeatSpaces(matcher.group().length()));
			}
		}
		
		
		// for testing only
		for(Lexeme l : Lexemes) {
			System.out.println(l.matchedWord+" "+l.relatedToken.name);
		}
		
	}
	
	public void createTokens(){
		
		// ID,Char
		
		Tokens.add(new Token("M_COMMENTS","-	\\/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*\\/"));
		Tokens.add(new Token("S_COMMENTS","\\/\\/.*\\n"));
		Tokens.add(new Token("STRING_LITERAL","\".*\""));
		
		Tokens.add(new Token("FLOAT_LITERAL","(\\b)*\\d*\\.\\d+\\b"));
		Tokens.add(new Token("INTEGRAL_LITERAL","\\b\\d+\\b"));
		
		Tokens.add(new Token("SYSTEM.OUT.PRINTLN","\\bSystem.out.println\\b"));
		Tokens.add(new Token("IF","\\bif\\b"));
		Tokens.add(new Token("INT","\\bint\\b"));
		Tokens.add(new Token("ELSE","\\belse\\b"));
		Tokens.add(new Token("MAIN","\\bmain\\b"));
		Tokens.add(new Token("THIS","\\bthis\\b"));
		Tokens.add(new Token("TRUE","\\btrue\\b"));
		Tokens.add(new Token("VOID","\\bvoid\\b"));
		Tokens.add(new Token("CLASS","\\bclass\\b"));
		Tokens.add(new Token("FALSE","\\bfalse\\b"));
		Tokens.add(new Token("WHILE","\\bwhile\\b"));
		Tokens.add(new Token("LENGTH","\\blength\\b"));
		Tokens.add(new Token("PUBLIC","\\bpublic\\b"));
		Tokens.add(new Token("PRIVATE","\\bprivate\\b"));
		Tokens.add(new Token("PROTECTED","\\bprotected\\b"));
		Tokens.add(new Token("RETURN","\\breturn\\b"));
		Tokens.add(new Token("STATIC","\\bstatic\\b"));
		Tokens.add(new Token("NEW","\\bnew\\b"));
		Tokens.add(new Token("STRING","\\bstring\\b"));
		Tokens.add(new Token("FLOAT","\\bfloat\\b"));
		Tokens.add(new Token("CHARACTER","\\bchar\\b"));
		Tokens.add(new Token("BOOLEAN","\\bboolean\\b"));
		Tokens.add(new Token("EXTENDS","\\bextends\\b"));
		Tokens.add(new Token("NULL","\\bnull\\b"));
		Tokens.add(new Token("ABSTRACT","\\babstract\\b"));
		Tokens.add(new Token("ASSERT","\\bassert\\b"));
		Tokens.add(new Token("BREAK","\\bbreak\\b"));
		Tokens.add(new Token("CONTINUE","\\bcontinue\\b"));
		Tokens.add(new Token("BYTE","\\bbyte\\b"));
		Tokens.add(new Token("CASE","\\bcase\\b"));
		Tokens.add(new Token("CATCH","\\bcatch\\b"));
		Tokens.add(new Token("CONST","\\bconst\\b"));
		Tokens.add(new Token("DEFAULT","\\bdefault\\b"));
		Tokens.add(new Token("DO","\\bdo\\b"));
		Tokens.add(new Token("DOUBLE","\\bdouble\\b"));
		Tokens.add(new Token("ENUM","\\bENUM\\b"));
		Tokens.add(new Token("FINAL","\\bfinal\\b"));
		Tokens.add(new Token("FINALY","\\bfinaly\\b"));
		Tokens.add(new Token("FOR","\\bfor\\b"));
		Tokens.add(new Token("GOTO","\\bgoto\\b"));
		Tokens.add(new Token("IMPLEMENTS","\\bimplements\\b"));
		Tokens.add(new Token("IMPORT","\\bimport\\b"));
		Tokens.add(new Token("INSTANCEOF","\\binstanceof\\b"));
		Tokens.add(new Token("INTERFACE","\\binterface\\b"));
		Tokens.add(new Token("SHORT","\\bshort\\b"));
		Tokens.add(new Token("SUPER","\\bsuper\\b"));
		Tokens.add(new Token("SWITCH","\\bswitch\\b"));
		Tokens.add(new Token("THROW","\\bthrow\\b"));
		Tokens.add(new Token("TRY","\\btry\\b"));
		
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
		Tokens.add(new Token("ERROR","\\S+"));

		
	}
	
	private String repeatSpaces(int times) {
        return new String(new char[times]).replace("\0", " ");
    }
}
