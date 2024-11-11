// This class is an extension of the NodeStmt node it contains an
// id and expr Node which is an assignment statement.

public class NodeStmtAssn extends NodeStmt{

    private NodeFactId id;
    private NodeExpr expr;

    // Constructor of the Assn node
    public NodeStmtAssn(NodeFactId id, NodeExpr expr) {
        this.id = id;
        this.expr = expr;
    }

    // Evaluates the expression which is an assignment
    public double eval(Environment env) throws EvalException {
        return env.put(id.code(), new NodeWr(expr).eval(env));
    }

    // Returns a string of the assignment
    public String code() {
        return id.code() + " = " + expr.code();
    }
}
