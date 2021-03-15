package patternsandmatchers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class demonstrating the use of Pattern and Matcher to check whether an array of Strings match a regex.
 * 
 * @author Owen Charles
 * @version 2020/11/18
 */
public class PatternsAndMatchers {
	
	/**
	 * This method of matching patterns is simple but only efficient for a single use, as each time Pattern is
	 * recompiled.
	 * 
	 * The method is largely redundant as it would be quicker for a user to simply code the implementation; however, it
	 * is shown here for demonstration purposes.
	 * 
	 * @param  regex is the String that is the regex to be used.
	 * @param  string is of type String and will be matched against the regex.
	 * @return true iff the String matches the regex.
	 */
	public static boolean matchingStrings(String regex, String string) {
		
		return Pattern.matches(regex, string);
	}
	
	/**
	 * The overloaded matchingStrings method calculates whether an array of Strings matches a regex via the Pattern and
	 * Matcher classes.
	 * 
	 * Each boolean at position 'i' in the returned boolean array represents whether the String in position 'i' of the
	 * String array matches the regex or not.
	 * 
	 * For example: String [] stringsToMatch   = [0, 1, 2, ... n - 1];
	 * 				boolean[] doesStringMatch  = [0, 1, 2, ... n - 1];
	 * 
	 * 				The boolean at doesStringMatch[0] indicates whether the String at stringsToMatch[0] matched the
	 * 				regex.
	 * 
	 * 				The boolean at doesStringMatch[1] indicates whether the String at stringsToMatch[1] matched the
	 * 				regex, etc.
	 * 
	 * Example:
	 * 
	 * input  = matchingStrings("a*b", {"aaaaaab", "ab", "b", "bb", "abb", "aabb", "abbbbbbbbb"});
	 * output = {true true true false false false false}; 
	 * 
	 * @param  regex is of type String and is the regex that will be used to compare to each String in the String array.
	 * 
	 * @param  stringsToMatch is the array of Strings that is to be compared with the regex. 
	 * 
	 * @return An array of booleans with each boolean true iff the String from the String array matches the regex.
	 */
	public static boolean[] matchingStrings(String regex, String[] stringsToMatch) {
		
		// First, an empty boolean array is initialised and a Pattern instance is created with the regex.
		      boolean[]     doesStringMatch = new boolean[stringsToMatch.length];
		final Pattern       pattern         = Pattern.compile(regex)            ;

		/* Next, the String array is iterated over, and each String is matched with the Pattern instance, creating a
		 * new Matcher instance. The Matcher.matches() method is then called to check whether the String matched the
		 * regex, resulting in a boolean. The boolean is then added to the array.
		 */
		for (int i = 0; i < stringsToMatch.length && i < doesStringMatch.length; i++) {

			Matcher matcher    = pattern.matcher(stringsToMatch[i]);
			doesStringMatch[i] = matcher.matches();

		}
		
		// Lastly, the boolean array is returned.
		return doesStringMatch;
	}

	public static void main(String[] args) {
		
		// regex meaning: Any number of 'a' followed by a single 'b'.
		final String    regex             =  "a*b";
		final String [] stringsToMatchOne = {"aaaaaab", "ab", "b", "bb", "abb", "aabb", "abbbbbbbbb"};
		final boolean[] results            = matchingStrings(regex, stringsToMatchOne);
		
		// Print out the result.
		for (boolean match : results) {
			
			System.out.print(match + " ");
		}
	}
}
