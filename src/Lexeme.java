
public class Lexeme implements Comparable<Lexeme>{
	public String matchedWord;
	public int startIndex;
	public Token relatedToken;
	
	public Lexeme(String matchedWord, int startIndex, Token relatedToken) {
		this.matchedWord = matchedWord;
		this.startIndex = startIndex;
		this.relatedToken = relatedToken;
	}

	@Override
	public int compareTo(Lexeme lexeme) {
		return Integer.compare(startIndex, lexeme.startIndex);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Lexeme))
			return false;
		Lexeme other = (Lexeme)obj;
		return startIndex == other.startIndex;
	}
	
	@Override
	public int hashCode() {
		return startIndex;
	}
}
