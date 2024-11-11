// This class is an extension of the Node object. It has an expression value
// and a term which can be evaluated in the parse tree. This node bridges
// two values using an Addop value (+ or -)

public class NodeExpr extends Node {

	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	// Constructor of the Expr node
	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term=term;
		this.addop=addop;
		this.expr=expr;
	}

	// Adds onto the expression. If there is nothing, the node that is provided
	// will be added to. Else, then it appends to itself
	public void append(NodeExpr expr) {
		if (this.expr==null) {
			this.addop=expr.addop;
			this.expr=expr;
			expr.addop=null;
		} else
			this.expr.append(expr);
	}

	// Runs the expression. If null, evaluates the the term (null evaluation). Otherwise
	// it will run the operation by calling op(x,y)
	public double eval(Environment env) throws EvalException { // Modified to return double
		return expr==null
			? term.eval(env)
			: addop.op(expr.eval(env),term.eval(env));
	}

	// Returns the expression in the Node
	public String code() {
		return (expr==null ? "" : expr.code()+addop.code())+term.code();
	}

}
