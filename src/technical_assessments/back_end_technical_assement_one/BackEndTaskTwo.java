import java.util.Arrays;
import java.util.Collections;

/**
 * This class is the solution to Task 2 for the Candidate Back-End assessment for the Graduate Software Engineer
 * position. The solution is not quite complete. In the case of replacing identical consecutive characters with
 * asterisks (*), they are only replaced with a single asterisk.
 * 
 * Task 2 is described as the following:
 * 
 * You are given an array of strings. Each array element contains one or several words separated with single spaces.
 * Write a function to reverse the order of the words in each element of the array. Additionally where a word contains
 * a sequence of the same character, replace the sequence with * characters of the same length.
 * 
 * Example: Input    [ 'Hello World', 'Bye World', 'Useless World' ]
 * 		    Output   [ 'World He**o', 'World Bye', 'World Usele**' ] 
 *  
 * @author Owen Charles
 * @version 2020/10/17
 *
 */
public class BackEndTaskTwo {
	
	/**
	 * The method reverses the words in the input String array and then censors the repetitive characters.
	 * 'Censored' refers to the act of replacing consecutive repetitive characters with asterisks (*). 
	 * 
	 * @param  input is a String array containing the words to be reversed and censored. 
	 * @return A String array containing the reversed and censored versions of the String phrases in input.
	 */
	public static String[] reverseAndCensor(String[] input) {
		
		String[] holdingArray;
		String[] output = new String[input.length];
		
		for (int i = 0; i < input.length; i++) {
			
			holdingArray = input[i].split(" ");
			
			// Reverse stage
			Collections.reverse(Arrays.asList(holdingArray));
			
			// Censor stage			
			for (int j = 0; j < holdingArray.length; j++) {
				
				/* Replaces the repetitive characters with a single asterisk.
				 * Citation for the regex expression:
				 * David Z, https://stackoverflow.com/questions/664194/how-can-i-find-repeated-characters-with-a-regex-in-java
				 */
				holdingArray[j] = holdingArray[j].replaceAll("(\\w)\\1+", "*");
			}
			
			// Add phrase to output.
			output[i] = String.join(" ", holdingArray);
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		String[] input = {"Hello World", "Bye World", "Useless World"};
		
		String[] output = reverseAndCensor(input);
		
		// Prints the output to the console
		for (String element : output) {
			
			System.out.println(element);
		}
	}
}
