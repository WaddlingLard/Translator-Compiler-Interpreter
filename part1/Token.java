// This class models a token, which has two parts:
// 1) the token itself (e.g., "id" or "+")
// 2) the token's lexeme (e.g., "foo")

public class Token {

	private String token;
	private String lexeme;

	// Constructor that takes in the token and lexeme
	public Token(String token, String lexeme) {
		this.token=token;
		this.lexeme=lexeme;
	}

	// Constructor when only a token is given. The lexeme is written with the token
	public Token(String token) {
		this(token,token);
	}

	// Returning the string literal token of the token
	public String tok() { return token; }

	// Returning the lexeme of the token
	public String lex() { return lexeme; }

	// Determining if the token is equal to a provided one
	public boolean equals(Token t) {
		return token.equals(t.token);
	}

	// Returning a string of the token
	public String toString() {
		return "<"+tok()+","+lex()+">";
	}

}
