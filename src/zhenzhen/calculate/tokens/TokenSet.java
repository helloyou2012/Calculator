package zhenzhen.calculate.tokens;

public class TokenSet {
	private int tokens;

	public TokenSet(int tokens) {
		this.tokens = tokens;
	}
	public TokenSet(TokenSet t) {
		this.tokens = t.tokens;
	}
	public static TokenSet add(TokenSet t1, TokenSet t2){
		return new TokenSet(t1.tokens | t2.tokens);
	}
	public static TokenSet add(TokenSet t1,int t2){
		return new TokenSet(t1.tokens | t2);
	}
	public boolean Contains( int type )
    {
        return ( tokens & type) != 0;
    }

}
