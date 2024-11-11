// This class is an extension of the Node object. It takes in multiplication or
// division operators for the parse tree and then executes the appropriate operation

public class NodeMulop extends Node {

	private String mulop;

	// Constructor of the Mulop node
	public NodeMulop(int pos, String mulop) {
		this.pos=pos;
		this.mulop=mulop;
	}

	// Runs the evaluation on two values either * or /. If fails, it throws an EvalException
	public double op(double o1, double o2) throws EvalException { // Modified to return and take in doubles
		if (mulop.equals("*"))
			return o1*o2;
		if (mulop.equals("/"))
			return o1/o2;
		throw new EvalException(pos,"bogus mulop: "+mulop);
	}

	// Returns the operator * or /
	public String code() { return mulop; }

}
