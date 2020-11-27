/**
 * This class is the solution to Task 3 for the Candidate Back-End assessment for the Graduate Software Engineer
 * position. The Big O complexity of the solution is linear O(n).
 *  
 * Task 3 is described as the following:
 * 
 * "To see if a number is divisible by 3, you need to add up the digits of its decimal notation, and check if the sum
 * is divisible by 3. 
 * 
 * "To see if a number is divisible by 11, you need to split its decimal notation into pairs of digits (starting from
 * the right end), add up corresponding numbers and check if the sum is divisible by 11.
 * 
 * "Given an array of integers, write a function that tests each integer for their divisibility into 3 and 11 using the
 * above methods.
 * 
 * "The function must return a new array containing the results:
 * 
 * - If the integer is divisible by 3, the result is 'fizz'
 * - If the integer is divisible by 11, the result is 'buzz'
 * - If the integer is divisible by both 3 and 11, the result is 'fizzbuzz'
 * - If the integer isn't divisible by 3 or 11, the result is 'baz'
 * 
 * "Example:
 *  Input    [ 2, 3, 10, 11, 12, 22, 297 ]
 *  Output   [ 'baz', 'fizz', 'baz', 'buzz', 'fizz', 'buzz', 'fizzbuzz' ]"
 *  
 * 
 * Precondition 1: The length of the input and output arrays must be identical.
 * 
 * Precondition 2: The order of the array must match. That is, input[0] corresponds to output[0], input[1] corresponds
 * 				   to output[1], and so on.
 * 
 * Precondition 3: The numbers of the input must be whole numbers and greater than zero.
 * 
 * Assumption: A value is divisible iff there is no remainder value. 
 * 
 * @author Owen Charles
 * @version 2020/10/17
 *
 */
public class BackEndTaskThree {
	
	/**
	 * The method checks whether a number is divisible by 3 via adding up the digits of its decimal notation, and
	 * check if the sum is divisible by 3. 
	 * 
	 * @param  number is the number that is to be checked if it is divisible by 3. 
	 * @return a boolean that is true iff the number is divisible by 3. Otherwise false is returned.
	 */
	public static boolean checkDivThree(int number) {
		
		/* The type of the number is converted from an int to a String so that it can be split into its individual
		 * digits and stored in an array. The digits are then iterated over, converted back to their integer values and
		 * summed.
		 */
		String   integerToString      = String         .valueOf(number);
		String[] stringRepOfEachDigit = integerToString.split("")      ;
		
		int sum = 0;
		
		for (int i = 0; i < stringRepOfEachDigit.length; i++) {
			
			sum += Integer.parseInt(stringRepOfEachDigit[i]);
			
		}
		
		// Finally, the sum is checked whether it is divisible by 3 via using the modulus operator.
		return sum % 3 == 0;
		
	}
	
	/**
	 * The method checks whether a number is divisible by 11 via splitting its decimal notation into pairs of
	 * digits (starting from the right end), adding up the corresponding numbers, and finally checking if the sum is
	 * divisible by 11.
	 * 
	 * @param  number is the number that is to be checked if it is divisible by 11. 
	 * @return a boolean that is true iff the number is divisible by 11. Otherwise false is returned.
	 */
	public static boolean checkDivEleven(int number) {
		
		/* The type of the number is converted from an int to a String so that it can be split into its individual
		 * digits and stored in an array. The digits are then iterated over, converted back to their integer values and
		 * summed.
		 */
		String   integerToString      = String         .valueOf(number);
		String[] stringRepOfEachDigit = integerToString.split("")      ;
		
		/* Within each pair of digits, the first one (from right to left) will be a unit, and the second one a 'tens'.
		 * Therefore, the boolean variable 'unit' is used to switch between the two as we add them up.
		 */
		boolean unit = true;
		
		int sum = 0;
		
		for (int i = stringRepOfEachDigit.length - 1; i >= 0; i--) {
			
			/* If the digit from the pair is a unit, then it is simply converted back to its integer form and added to
			 * the sum.
			 */
			if (unit) {
				
				sum = sum + Integer.parseInt(stringRepOfEachDigit[i]);
				
				unit = false;
				
			/* Else, the digit is the 'tens' part of the pair, and so is multiplied by ten, converted back to an
			 * integer, and added to the sum.
			 */
			} else { 
				sum = sum + (Integer.parseInt(stringRepOfEachDigit[i]) * 10);
				
				unit = true;
			}
		}
		
		// Finally, the sum is checked whether it is divisible by 11 via using the modulus operator.
		return sum % 11 == 0;
	}
	

	/**
	 * The divisible method iterates through the input and checks whether each number is divisible via 3, 11, or both.
	 * The method makes use of two helper methods checkDivThree and checkDivEleven in order to ensure modularity and
	 * improve code readability.
	 * 
	 * @param  checkInts is the input array containing the numbers to be checked.
	 * @return A String array containing the corresponding words for each number of the input.
	 */
	public static String[] divisible(int[] checkInts) {
		
		String[] output = new String[checkInts.length];
		
		for (int i = 0; i < checkInts.length; i++) {
			
			if (checkDivThree(checkInts[i]) && checkDivEleven(checkInts[i])) {
				
				output[i] = "fizzbuz";
				
			} else if (checkDivThree(checkInts[i])) {
				
				output[i] = "fizz";
			
			} else if (checkDivEleven(checkInts[i])) {
				
				output[i] = "buzz";
			
			} else // The number is not divisible by 3 or 11
				
				output[i] = "baz";
		}
		
		return output;
		
	}
	
	
	public static void main(String[] args) {

		   int[] input  = {2, 3, 10, 11, 12, 22, 297};
		String[] output = divisible(input)			 ;
		
		// The output is printed to the console.
		for (String element : output) {
			
			System.out.println(element);
		}
	}
}
