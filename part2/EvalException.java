// This class is an exception that is produced when their is a violation of the evaluation

public class EvalException extends Exception {

	private int pos;
	private String msg;

	// Constructor of the exception
	public EvalException(int pos, String msg) {
		this.pos=pos;
		this.msg=msg;
	}

	// Produces a string of the EvalException
	public String toString() {
		return "eval error"
			+", pos="+pos
			+", "+msg;
	}

}
