// This class is an extension of the Node object. It contains a statement
// and if there is more code it will store it in another block node. This
// node efffectively holds code in "blocks" hence its name

public class NodeBlock extends Node{
    
    private NodeStmt stmt;
    private NodeBlock block;

    // Constructor of the Block node
    public NodeBlock(NodeStmt stmt, NodeBlock block) {
        this.stmt = stmt;
        this.block = block;
    }

    // Adds onto the block. If there is nothing, the node that is provided will
    // be added to. Else, then it appends to itself
    public void append(NodeBlock block) {
        if(this.block == null) {
            this.block = block;
        } else {
            this.block.append(block);
        }
    }

    // Getter for the block (I don't think this method is used)
    public NodeBlock getNodeBlock(){
        return block;
    }

    // Runs the block of code. If it doesn't contain a block after itself then
    // it will only evaluate the only statement provided
    public double eval(Environment env) throws EvalException { // Unsure how to evaluate a block
        if (block == null) {
            return stmt.eval(env);
        } else {
            return stmt.eval(env) + block.eval(env);
        }
    }

    // Returns the block in the Node in string literal
    public String code() {
        return (block==null ? stmt.code() + ";": stmt.code()+";"+block.code());
    }

}


