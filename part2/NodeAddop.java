// This class is an extension of the Node object. It takes in adding or subtracting
// operators for the parse tree and then executes the appropriate operation

public class NodeAddop extends Node {

	private String addop;

	// Construtor of the Addop node
	public NodeAddop(int pos, String addop) {
		this.pos=pos;
		this.addop=addop;
	}

	// Runs the evaluation on two values either + or -. If fails, it throws an EvalException
	public double op(double o1, double o2) throws EvalException { // Modified to return double and take in doubles
		if (addop.equals("+"))
			return o1+o2;
		if (addop.equals("-"))
			return o1-o2;
		throw new EvalException(pos,"bogus addop: "+addop);
	}

	// Returns the operator + or -
	public String code() { return addop; }

}
