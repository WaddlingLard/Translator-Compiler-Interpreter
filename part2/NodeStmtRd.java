// This class is an extension of the NodeStmt object. It contains
// a FactId given by the user insert something with.
import java.util.Scanner;

public class NodeStmtRd extends NodeStmt {

    private static Scanner scan = new Scanner(System.in);
    private NodeFactId id;

    // Constructor of the Rd node
    public NodeStmtRd(NodeFactId id) {
        this.id = id;
    }

    // Evaluation of the reading. There is a value and now its
    // waiting for a provided input from the user
    public double eval(Environment env) throws EvalException {
        //Scanner static scan = new Scanner(System.in);
        //scan = new Scanner(System.in);
        double val = Double.parseDouble(scan.next());
        env.put(id.code(), val);
        // scan.close();
        return id.eval(env);
    }

    // Return the string literal of this
    public String code() { return "scanf(\"%lf\",&" +id.code() +");"; }

}
