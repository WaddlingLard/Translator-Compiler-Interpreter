// This class is an exception that produces one when there is a violation of the syntax

public class SyntaxException extends Exception {

	private int pos;
	private Token expected;
	private Token found;

	// Constructor of the exception
	public SyntaxException(int pos, Token expected, Token found) {
		this.pos=pos;
		this.expected=expected;
		this.found=found;
	}

	// Produces a string of the SyntaxException
	public String toString() {
		return "syntax error"
			+", pos="+pos
			+", expected="+expected
			+", found="+found;
	}

}
