package utilities;

public class Utilities {
	//A collection of small utilities used in various parts of the program

	public static int intParseDefault(String input, int defaultValue) {
		// Parses an int, returns a set default value if parsing fails
		
		int output = 0;
		try {
			output = Integer.parseInt(input);
		} catch (NumberFormatException exec) {
			output = defaultValue;
		}
		return output;
	}
	
	
}