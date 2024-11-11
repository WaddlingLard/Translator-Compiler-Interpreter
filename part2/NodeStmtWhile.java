// This class is an extension of the NodeStmt object. It is a holder that 
// contains a conditional (boolExpr) and a statement (stmt) to execute
// on evaluation 

public class NodeStmtWhile extends NodeStmt {
    
    private NodeBoolExpr bool;
    private NodeStmt stmt; // Unsure if needs to be NodeStmtSt

    // Constructor of the While node
    public NodeStmtWhile(NodeBoolExpr boolExpr, NodeStmt stmt) {
        this.bool = boolExpr;
        this.stmt = stmt;
    }

    // Evaulates the given while statement as long as the conditional is met
    public double eval (Environment env) throws EvalException {
        double total = 0;
        while(bool.eval(env) == 1.0) {
            total += stmt.eval(env);
        }
        return total;
    }

    // Returns the assignment in a string literal
    public String code() { return "while(" + bool.code() + "){" + stmt.code() + "}"; } 

}
