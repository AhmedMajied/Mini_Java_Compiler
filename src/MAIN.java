
public class MAIN {
	public static void main(String[] args){
		StringBuffer text = new StringBuffer("int voida void");
		
		LexicalAnalysis lexicalAnalysis = new LexicalAnalysis();
		lexicalAnalysis.extractTokens(text);
		//lexicalAnalysis.extractTokens("class myclass{ /* my comment */ ; */ };");
		
	}
}
