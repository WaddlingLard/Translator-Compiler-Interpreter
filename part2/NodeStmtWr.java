// This class is an extension of the NodeStmt object. It contains
// an expression that is evaluated and printed out. This is effectively
// a copy of the NodeWr but in order to maintain proper hierarchy this
// one is an implementation of NodeStmt.

public class NodeStmtWr extends NodeStmt{
    
    private NodeExpr expr;

    // Constructor of the Wr node
    public NodeStmtWr(NodeExpr expr) {
        this.expr = expr;
    }

    // The evaluation is ran in the environment and then is
    // returned. It also tests to see if it is equal to itself
    // with bits of logic
    public double eval(Environment env) throws EvalException { // Modified
        double d=expr.eval(env); // Modified to take in double values
        int i=(int) d;
        if (i==d)
            System.out.println(i);
        else
            System.out.println(d);
        return d;
    }

    // Returns the string literal form of code that allows the
    // C compiled file to print out the expression's result
    public String code() { // Modified to instead output a double instead of truncating it

        return "printf(\"%g\\n\","
                +"(double) ("
                +expr.code()
                +"));";
    }


//    // Evaluates the expression and prints it out to the console
//    public double eval(Environment env) throws EvalException {
//        double total = expr.eval(env);
//        System.out.println(total);
//        return total;
//    }
//
//    // Returns the string in literal
//    public String code() {
//        return "printf(\"%g\",(double)" + expr.code() + ");";
//    }
}
