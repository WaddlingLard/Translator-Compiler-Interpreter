// This class is an extension of the NodeFact object. It is the fact
// of the actual node. It is evaluated to locate the location of the id

public class NodeFactId extends NodeFact {

	private String id;

	// Constructor of the FactId node
	public NodeFactId(int pos, String id) {
		this.pos=pos;
		this.id=id;
	}

	// Evaluates the location of the id by calling get get() on the Environment
	public double eval(Environment env) throws EvalException { // Modifed to return a double
		//System.err.println(env.get(pos, id));
		return env.get(pos,id);
	}

	// Returns the id in a string literal
	public String code() { return id; }

}
