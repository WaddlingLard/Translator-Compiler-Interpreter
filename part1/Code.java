// This class takes the code provided and acts as a compiler to produce an executable C file

import java.io.*;

public class Code {

	private final String[] prologue={ // Added the math header file to use a function that can be later used in conversion of integers to doubles
		"#include <stdio.h>",
		"int main() {",
	};

	private final String[] epilogue={
		"return 0;",
		"}",
	};

	// This is the compiler. Using an environment variable, you can generate a .c file which can be executed

	public Code(String code, Environment env) {
		String fn=System.getenv("Code");
		if (fn==null)
			return;
		try {
			BufferedWriter f=new BufferedWriter(new FileWriter(fn+".c"));
			for (String s: prologue)
				f.write(s+"\n");
			f.write(env.toC());
			f.write(code);
			for (String s: epilogue)
				f.write(s+"\n");
			f.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
