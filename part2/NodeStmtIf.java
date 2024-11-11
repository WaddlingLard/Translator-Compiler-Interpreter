// This class is an extension of the NodeStmt object. It contains the 
// building blocks for an if-statement and has the ability to have an 
// else condition attacted to it if provided

public class NodeStmtIf extends NodeStmt{
    
    private NodeBoolExpr bool;
    private NodeStmt stmt;
    private NodeStmt stmt2; // Might not be needed depending on the type of if-statement
    private boolean ifElse = false;

    // Constructor of the If node
    public NodeStmtIf(NodeBoolExpr expr, NodeStmt stmt, NodeStmt stmt2) {
        this.bool = expr;
        this.stmt = stmt;
        this.stmt2 = stmt2;
        if (this.stmt2 == null) { // Recognizing if it is an if-else

        } else {
            ifElse = true;
        }
    }

    // Evaluates the if-statment
    // 1.0 is true and 0.0 is false 
    // If false, execute else, otherwise true
    public double eval (Environment env) throws EvalException {
        if (!ifElse) { 
            if (bool.eval(env) == 1.0) { // Only if-statement
                return stmt.eval(env);
            }
        } else { // If-else statement
            if (bool.eval(env) == 1.0) {
                return stmt.eval(env);
            } else {
                return stmt2.eval(env);
            }
        }
        return 0.0; // Nothing got done!
    }

    // Returns the if-statement in a string literal
    public String code() {
        if(!ifElse) {
            return "if(" + bool.code() +"){" + stmt.code() + "}";
        } 
        return "if(" + bool.code() + "){" + stmt.code() + "}else{" + stmt2.code() + "}";
    }



}
