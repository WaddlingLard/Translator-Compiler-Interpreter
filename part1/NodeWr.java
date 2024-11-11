// This class is an extension to the Node object. This is used for
// the compiled file in C that allows the expression to be executed and 
// output a value in C.

public class NodeWr extends Node {

	private NodeExpr expr;

	// Constructor of the Wr node
	public NodeWr(NodeExpr expr) {
		this.expr=expr;
	}

	// The evaluation is ran in the environment and then is 
	// returned. It also tests to see if it is equal to itself
	// with bits of logic
	public double eval(Environment env) throws EvalException { // Modified
		double d=expr.eval(env); // Modified to take in double values
		int i=(int) d;
		if (i==d)
			System.out.println(i);
		else
			System.out.println(d);
		return d;
	}

	// Returns the string literal form of code that allows the
	// C compiled file to print out the expression's result
	public String code() { // Modified to instead output a double instead of truncating it

		return "printf(\"%g\\n\","
				+"(double) ("
				+expr.code()
				+"));";
	}

}
