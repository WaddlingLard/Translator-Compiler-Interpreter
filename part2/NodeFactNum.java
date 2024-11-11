// This class is an extension of the NodeFact object. It is the fact
// of the actual node. It is evaluated to turn into a calculable form (double).

public class NodeFactNum extends NodeFact {

	private String num;

	// Constructor of the FactNum node
	public NodeFactNum(String num) {
		this.num=num;
	}

	// Evaluates the num by converting into an integer and returning it
	public double eval(Environment env) throws EvalException { // Modified in order to properly parse doubles
		return Double.parseDouble(num);
	}

	// Returns the num in string literal form (double)
	public String code() {
		return Double.parseDouble(num) + ""; 
	}

}
