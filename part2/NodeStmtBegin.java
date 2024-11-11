// This class is an extension of the NodeStmt object. It is a holder
// that contains a block of code provided from the user.

public class NodeStmtBegin extends NodeStmt {

    private NodeBlock block;

    // Constuctor of the Being node
    public NodeStmtBegin(NodeBlock block) {
        this.block = block;
    }

    // Evaluates the block of code 
    public double eval (Environment env) throws EvalException {
        return block.eval(env);
    }

    // Returns the assignment in a string literal
    public String code() { return block.code(); }

}    

