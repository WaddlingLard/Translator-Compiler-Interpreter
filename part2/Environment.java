// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

import java.util.HashMap;

public class Environment {

	private String[] map = {};
	private HashMap<String, Double> hashMap = new HashMap<String, Double>(100); // Used to store the value associated to the keys, it is capable of holding a100 values
	// ALSO MODIFIED TO TAKE IN DOUBLES

	public double put(String var, double val) { // Modified to accept double values and return them too

		int i;

		for (i = 0; i < map.length; i++) { // Checking if the key is already in the map
			if (map[i].compareTo(var) == 0) { // Found
				hashMap.replace(var, val);
				return val;
			}
		}
		// Not in map currently, adding to the map
		String[] tempMap = new String[map.length + 1];
		for (i = 0; i < map.length; i++) {
			tempMap[i] = map[i];
		}
		tempMap[i] = var; // Adding new value
		map = tempMap; // Setting the "new" map
		hashMap.put(var, val); // Putting it in the hashMap
		return val;
	}

	public double get(int pos, String var) throws EvalException { // Method modified to return double

		// System.err.println("GETTING");

		for (int i = 0; i < map.length; i++) {
			if (map[i].compareTo(var) == 0) { // var found
				// System.err.println("FOUND " + hashMap.get(var));
				return hashMap.get(var);
			}
		} 

		throw new EvalException(-1,"Invalid id not in map!");
	}

	public String toC() {
		String s = "";
		String sep = " ";
		for (String v : map) {
			s += sep + v;
			sep = ",";
		}
		return s == "" ? "" : "double" + s + ";\nx=0;x=x;\n"; // Modified string to appropriately assign to double
	}

}
