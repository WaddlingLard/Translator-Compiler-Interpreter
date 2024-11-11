// This class is an extension of the Node object. It has two expressions
// combined with a relop in order to evaluate to either true (1) or false (0).
// This is effectively a compound logic statement since it is using expression nodes
// to compare.

public class NodeBoolExpr {
    
    private NodeExpr expr;
    private NodeRelop relop;
    private NodeExpr expr2;

    // Constructor of the NodeBoolExpr
    public NodeBoolExpr(NodeExpr expr, NodeRelop relop, NodeExpr expr2) {
        this.expr = expr; 
        this.relop = relop;
        this.expr2 = expr2;
    }

    // Runs the logic to see if it evaluates to either true or false form the two expressions
    // and relop provided
    public double eval(Environment env) throws EvalException {
        if (expr2 == null) { // is there a second expression? this might be wrong
            return expr.eval(env);
        } else {
            return relop.op(expr.eval(env), expr2.eval(env));
        }
    }

    // Returns the expression in the Node in string literal
    public String code() {
        return expr.code() + relop.code() + expr2.code();
        // if (relop == null || expr2 == null) { // this conditional seems funky
        //     return "";
        // } else {
        //     return expr.code() + relop.code() + expr2.code();
        // }
    }

}
