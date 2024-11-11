// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.

public class Parser {

	private Scanner scanner;

	// Returing the match result of the last scan operation with a provided String

	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	// Returning the current value

	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	// Returning position of the scanner

	private int pos() {
		return scanner.pos();
	}

	// Parsing if the current value is using a comparator operator

	private NodeRelop parseRelop() throws SyntaxException {
		if (curr().equals(new Token("<"))) {
			match("<");
			return new NodeRelop(pos(), "<");
		}
		if (curr().equals(new Token("<="))) {
			match("<=");
			return new NodeRelop(pos(), "<=");
		}
		if (curr().equals(new Token(">"))) {
			match(">");
			return new NodeRelop(pos(), ">");
		}
		if (curr().equals(new Token(">="))) {
			match(">=");
			return new NodeRelop(pos(), ">=");
		}
		if (curr().equals(new Token("<>"))) {
			match("<>");
			return new NodeRelop(pos(), "<>");
		}
		if (curr().equals(new Token("=="))) {
			match("==");
			return new NodeRelop(pos(), "==");
		}
		return null;
	}


	// Parsing if the current value is using a unary muliplcation or division operator

	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}

	// Parsing if the current value is using a unary addition or subtraction operator

	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(), "-");
		}
		return null;
	}

	// Parsing a boolean expression

	private NodeBoolExpr parseBoolExpr() throws SyntaxException { // This method might be buggy lookout for it
		NodeExpr expr = parseExpr();
		NodeRelop relop = parseRelop();
		if (relop == null)
			return new NodeBoolExpr(expr, null, null); // Uncertain if this is needed, in the grammar its implied there is no other option
		NodeExpr expr2 = parseExpr();
		return new NodeBoolExpr(expr, relop, expr2);
	}


	// Due to the structure of the tree, this might not be needed but this method
	// directly parses a NodeFactId instead of having to go parse NodeFact
	private NodeFactId parseNodeFactIdBypass() throws SyntaxException { // Due to stmt having a condition where id is required to be parsed it would be helpful to "pull out" the parse for NodeFactId
		// if(curr().equals(new Token("id"))) { // Unsure if conditional is needed
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		// }
	}

	// Parsing an expression/fact

	private NodeFact parseFact() throws SyntaxException {

		if (curr().equals(new Token("EOF"))) {
			System.err.println("EQUALS");
		}


		if (curr().equals(new Token("-"))) { // '-' fact
			match("-");
			NodeFact fact = parseFact();
			return new NodeFactUnary(fact);
		}
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		}
		Token num = curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	// Parsing an expression that involves the * or / operators

	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm term = parseTerm();
		term.append(new NodeTerm(fact, mulop, null));
		return term;
	}

	// Parsing an expression that involves the + or - operators

	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	// Parsing if the current value is an assignment operator to a variable
	// This parsing method is obsolete
	private NodeAssn parseAssn() throws SyntaxException {
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(), expr);
		return assn;
	}

	// Parsing for an assignment node
	private NodeStmtAssn parseStmtAssn() throws SyntaxException {
		NodeFactId id = parseNodeFactIdBypass();
		match("=");
		NodeExpr expr = parseExpr();
		return new NodeStmtAssn(id, expr);
	}

	// Parsing the whole statement and ends with a ';' to stop and assign (no longer checks for ';')
	// There are now several more cases that this method can parse

	private NodeStmt parseStmt() throws SyntaxException {

		if (curr().equals(new Token("begin"))) { // start of ('begin' block 'end')
			// System.err.println("parsing started!" + curr().toString());
			match("begin");
			// System.err.println("begin found!" + curr().toString());
			
			NodeBlock block = parseBlock();
			// System.err.println("searching for end!" + curr().toString());
			match("end");
			// System.err.println("parsing completed!");
			return new NodeStmtBegin(block);
		}
		else if (curr().equals(new Token("while"))) { // start of ('while' boolexpr 'do' stmt)
			match("while");
			// System.err.println("HELP");
			NodeBoolExpr boolExpr = parseBoolExpr();
			match("do");
			NodeStmt stmt = parseStmt();
			return new NodeStmtWhile(boolExpr, stmt);
		}
		else if (curr().equals(new Token("if"))) { // start of ('if' boolexpr 'then' stmt ('else' stmt))
			match("if");

			// System.err.println("searching for boolexpr");

			NodeBoolExpr boolExpr = parseBoolExpr();

			// System.err.println(boolExpr.code());

			match("then");

			NodeStmt stmt = parseStmt();

			try {
				match("else"); // Checking to see it the if statement has an else, if not it'll be handled
			} catch (SyntaxException e) {
				return new NodeStmtIf(boolExpr, stmt, null);
			}

			NodeStmt stmt2 = parseStmt();
			return new NodeStmtIf(boolExpr, stmt, stmt2);
		}
		else if (curr().equals(new Token ("wr"))) { // start of ('wr' expr)
			match("wr");
			NodeExpr expr = parseExpr();
			return new NodeStmtWr(expr);
		}
		else if (curr().equals(new Token ("rd"))) { // start of ('rd' id)
			match("rd");
			NodeFactId factId = parseNodeFactIdBypass();
			return new NodeStmtRd(factId);
		}
		NodeAssn assn = parseAssn(); // If it is nothing else
		// match(";"); To reflect current grammar this is extraneous
		//NodeStmt stmt = parseStmtAssn();
		NodeStmt stmtst= assn;
		return stmtst;
		//return stmt;
	}

	// Parsing the block of code provided also has an interation where
	// there is a statement preceding a block

	private NodeBlock parseBlock() throws SyntaxException { // I believe I accounted for when the ';' is missing
		
		// try {
		// 	NodeStmt stmt = parseStmt();

		// 	try {
		// 		match(";"); // Uncertain if needed as stmt checks for the ';' (might not be true only true in grammar1)
		// 	} catch (SyntaxException e) { // There is no ';'
		// 		System.err.println("Creating new null nodeBlock!");
		// 		return new NodeBlock(stmt, null);
		// 	}

		// 	NodeBlock block = parseBlock();
		// 	block.append(new NodeBlock(stmt, parseBlock())); // I believe this is correct
		// 	return block;

		// } catch (SyntaxException e) {
		// 	System.err.println("something went wrong!");
		// }

		NodeStmt stmt = parseStmt();
		// System.err.println("Found statement!" + curr().toString());
		try {
			NodeBlock block = new NodeBlock(stmt, null);
			match(";"); // Uncertain if needed as stmt checks for the ';' (might not be true only true in grammar1)
			// System.err.println("Additional block found!");
			block.append(parseBlock());

			// System.err.println(block.code());

			//block.append(parseBlock()); // I believe this is correct

			//System.err.println(block.code());
			return block;
		} catch (SyntaxException e) { // There is no ';'
			// System.err.println("Creating new null nodeBlock!");
			NodeBlock block = new NodeBlock(stmt, null);
			return block;
		}

		//return null;
	}

	// Beginning the parsing process. It does this by calling parseStmt() (now calls parseBlock()) and
	// the calls keep getting deeper

	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		scanner.next();
		 //NodeStmt stmt = parseStmt(); // This line isn't needed in the new grammar
		NodeBlock block = parseBlock();
		match("EOF");
		 //return stmt;
		return block;
	}

}
