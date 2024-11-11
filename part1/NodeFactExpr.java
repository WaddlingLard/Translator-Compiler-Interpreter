// This class is an extension of the NodeFact object. It is the fact
// of the actual node. It is evaluated to turn into what its represenation is.

public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	// Constructor of the FactExpr node
	public NodeFactExpr(NodeExpr expr) {
		this.expr=expr;
	}

	// Calls the eval() in the expr value which returns an integer
	public double eval(Environment env) throws EvalException { // Modified to return double
		return expr.eval(env);
	}

	// Returns the expression in string literal form
	public String code() { return "("+expr.code()+")"; }

}
