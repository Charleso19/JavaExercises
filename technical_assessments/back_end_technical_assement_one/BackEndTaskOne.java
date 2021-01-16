/**
 * This class is the solution to Task 1 for the Candidate Back-End assessment for the Graduate Software Engineer
 * position.
 * 
 * Task 1 is described as the following:
 * 
 * Consider a sequence of integers A1, A2, ... for which An = A(n-1) + A(n-2) for all n > 2. You are given the first
 * two elements of the sequence A1 and A2, and the index n. Write a function to output the n-th element of the sequence.
 * The function will take a single argument consisting of a single string which contains integers A1, A2 and n
 * separated by single spaces." 
 * 
 * Example: Input : '1 2 5' 
 * 			 Output:  8
 * 
 * @author Owen Charles
 * @version 2020/10/17
 */
public class BackEndTaskOne {
	
	
	/**
	 * The formula provided was identified as the Fibonacci sequence, and is thus named appropriately. The method
	 * utilised a linear implementation, rather than the recursion, and thus exhibits a linear Big O complexity O(n). 
	 * 
	 * Precondition 1: n > 2.
	 * 
	 * Precondition 2: The String must always be in the form of "A1 A2 n", where A1 and A2 are the first two
	 * 				   elements of the sequence, n is the nth term of the sequence, and the three elements are separated
	 * 				   via a single space only. 
	 * 
	 * Precondition 3: Both A1 and A2 must be greater than 0.
	 * 
	 * 
	 * @param  elementsAndN is the String that contains the first two elements and the n-th term in the form
	 * 		   "A1 A2 n".
	 * 
	 * @return Returns the element at the n-th term.
	 */
	public static int fibonacciSequence(String elementsAndN) {
		
		/* We first split the String via the single spaces and place them into a String array. We then iterate through
		 * the String array and convert the elements to integers in preparation for our calculations.
		 */
		String[] stringToArray 		   = elementsAndN.split(" ");
		int   [] extractedElementsAndN = new int[stringToArray.length];
		
		for (int i = 0; i < stringToArray.length; i++) {
			
			extractedElementsAndN[i] = Integer.parseInt(stringToArray[i]);
			
		}
		
		final int N = extractedElementsAndN[extractedElementsAndN.length - 1];
		
		// The first two elements will always be A1, and A2.
		int[] sequence    = new int              [N];
		      sequence[0] = extractedElementsAndN[0];
		      sequence[1] = extractedElementsAndN[1];
		      
		
		// We iterate from 'A2' up to and including 'An'
		for (int i = 2; i < N; i++) {
			
			sequence[i] = sequence[i - 1] + sequence[i - 2];
			
		}

		// Finally, we return the nth element. 
		return sequence[N - 1];
	}
	
	/**
	 * The main method calls the fibonacciSequence method and prints the result. The calling of this method completes
	 * Task 1.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		
		System.out.println(fibonacciSequence("1 2 5"));
		
	}
}
