// This class is an extension of the Node object. It contains an id 
// value for something to be assigned to and an expression which is
// evaluated in the parse tree. Using the evaluation it can then be
// stored into the environment temporarily.

public class NodeAssn extends NodeStmt {

	private String id;
	private NodeExpr expr;

	// Constructor of the Assn node
	public NodeAssn(String id, NodeExpr expr) {
		this.id = id;
		this.expr = expr;
	}

	// Evaluates the assignment with expression and id and then
	// "puts" it in the environment to be temporarily stored.
	public double eval(Environment env) throws EvalException { // Modified to take in double values
		return env.put(id, new NodeWr(expr).eval(env));
	}

	// Returns the code in string literal form containing the 
	// id, expression, and creates a new node that is the code
	// for use in a compiled C file
	// public String code() {
	// 	return id + "=" + expr.code() + ";" + new NodeWr(expr).code();
	// }

	public String code() {
		return new NodeWr(expr).code() + id + "=" + expr.code() + ";";
	}

}
