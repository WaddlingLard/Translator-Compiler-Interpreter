// This class is an extenstion of the NodeFact object. Due
// to its close DNA ties with NodeFact 

public class NodeFactUnary extends NodeFact{

    private NodeFact fact;

    // Constructor of the FactUnary node
    public NodeFactUnary(NodeFact fact) {
        this.fact = fact;
    }
    
    // Calls the eval() in the fact value which returns an integer
    public double eval(Environment env) throws EvalException { // Modified to return double
        return -fact.eval(env);
    }

    // Returns the expression in string literal form
    public String code() { return "-"+fact.code(); }

}
