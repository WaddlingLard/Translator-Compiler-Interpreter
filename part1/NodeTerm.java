// This class is an extension of the Node object. It has an expression value
// and a term which can be evaluated in the parse tree. This node bridges
// two values using a Mulop value (* or /)

public class NodeTerm extends Node {

	private NodeFact fact;
	private NodeMulop mulop;
	private NodeTerm term;

	// Constructor of the Term node
	public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
		this.fact=fact;
		this.mulop=mulop;
		this.term=term;
	}

	// Adds onto the expression. If there is nothing, the node that is provided
	// will be added to. Else, then it appends to itself
	public void append(NodeTerm term) {
		if (this.term==null) {
			this.mulop=term.mulop;
			this.term=term;
			term.mulop=null;
		} else
			this.term.append(term);
	}

	// Runs the expression. If null, evaulates the term (null evaluation).
	// Otherwise, it will run the operation by calling op(x,y)
	public double eval(Environment env) throws EvalException { // Modified to return double
		return term==null
			? fact.eval(env)
			: mulop.op(term.eval(env),fact.eval(env));
	}

	// Returns the expression in the Node 
	public String code() {
		return (term==null ? "" : term.code()+mulop.code())+fact.code();
	}

}
