
public class Lexeme {
	public String matchedWord;
	public int startIndex;
	public Token relatedToken;
	
	public Lexeme(String matchedWord, int startIndex, Token relatedToken) {
		this.matchedWord = matchedWord;
		this.startIndex = startIndex;
		this.relatedToken = relatedToken;
	}
}
