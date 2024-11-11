// This class is an extension of the Node object. It takes in comparator
// operators for the parse tree and then executes the appropriate operation

public class NodeRelop extends Node {
    
    private String relop;
    private final double TRUE = 1.0; // In order to treat true/false in numeric symbols 1 and 0 are used
    private final double FALSE = 0.0;

    // Constructor of the Relop node
    public NodeRelop(int pos, String relop) {
        this.pos = pos;
        this.relop = relop;
    }

    // Runs the evaluation on two values with boolean logic. If fails, EvalException is thrown
    public double op(double o1, double o2) throws EvalException { // 1 if true, 0 if false
        if (relop.equals("<")) {
            if (o1 < o2) {
                return TRUE;
            } else {
                return FALSE;
            }
        }
        if (relop.equals("<=")) {
            if (o1 <= o2) {
                return TRUE;
            } else {
                return FALSE;
            }
        }
        if (relop.equals(">")) {
            if (o1 > o2) {
                return TRUE;
            } else {
                return FALSE;
            }
        }
        if (relop.equals(">=")) {
            if (o1 >= o2) {
                return TRUE;
            } else {
                return FALSE;
            }
        }
        if (relop.equals("<>")) {
            if (o1 != o2) {
                return TRUE;
            } else {
                return FALSE;
            }
        }
        if (relop.equals("==")) {
            if (o1 == o2) {
                return TRUE;
            } else {
                return FALSE;
            }
        }
        throw new EvalException(pos, "bogus relop: " + relop);
    }

    // Returns the relop which is several
    public String code() { 
        if (relop.equals("<>"))
            return "!=";
        return relop; 
    }
}
