// This class, and its subclasses,
// collectively model parse-tree nodes.
// Each kind of node can be eval()-uated,
// and/or code()-generated.

public abstract class Node {

	protected int pos=0;

	// Evaluating this node isn't possible so an EvalException is thrown
	public double eval(Environment env) throws EvalException { // This is changed to double in order to evaluate double values
		throw new EvalException(pos,"cannot eval() node!");
	}

	// As this is the base node the return is an empty string
	public String code() { return ""; }

}
