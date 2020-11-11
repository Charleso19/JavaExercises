import java.util.ArrayList;
import java.util.List     ;
import java.util.SortedSet;
import java.util.TreeSet  ;

/**
 * The CommonValuesRecursive class is a Java recursive solution to the following problem:
 * 
 * "For beginners only:
 * Given 2 lists, say
 * lst1 = [1,1,2,3,5,8,13,21,34,55,89]
 * lst2 = [1,1, 2,3,4,5,6,7,8,9,10,11,12,13]
 * Write a program that returns a list that contains the elements that are common to both lists, without duplicates.
 * The output in this case is [1, 2, 3, 5, 8, 13]"
 * Citation: Yehuda Katz, 2020, (https://www.facebook.com/groups/pythonsnake2)
 * 
 * @author Owen Charles
 * @version 2020/09/11
 */
public class CommonValuesRecursive {
	
	/**
	 * This method returns the value positioned at index 0 of the List.  
	 * 
	 * @param  x is the List of integers whose head will be returned.
	 * @return Returns the head of the List 'x'.
	 */
	public static int getHead(List<Integer> x) {
		
		// Defensive programming.
		if (x.isEmpty()) {
			
			throw new IllegalArgumentException("x cannot be empty.");
			
		} else {
		
			return x.get(0);
		}
	}
	
	/**
	 * This method returns the tail of the List 'x'.
	 * 
	 * @param  x is the List of which the tail will be returned.
	 * @return Returns the tail of the List 'x'.
	 */
	public static List<Integer> getTail(List<Integer> x) {
		
		// Defensive programming.
		if (x.isEmpty()) {
			
			throw new IllegalArgumentException("x cannot be empty.");
		
		// If x is a single element, then there is no tail, so return an empty list.	
		} else if (x.size() == 1) {
			
			return x.subList(0, 0);
		
		} else {
		
			return x.subList(1, x.size());
		}
	}

	/**
	 * An overloaded private method that returns the common elements of integer array 'a' and 'b' via a recursive
	 * solution.  
	 * 
	 * @param a is a sorted (ascending) list of integers.
	 * @param b is a sorted (ascending) list of integers.
	 * @param commonElements is a SortedSet of the common elements between List a and List b.
	 * @return An ArrayList of Integers that are the common elements between List a and List b.
	 */
	private static List<Integer> duplicateVals(List<Integer> a, List<Integer> b, SortedSet<Integer> commonElements) {
		
		// Base cases:		
		if (a.isEmpty() || b.isEmpty()) {
			
			return new ArrayList<Integer>(commonElements);
		
		  // Else, the recursive steps are followed:
		} else {	
		
			if (getHead(a) == getHead(b)) {
				
				// Add common element to the set.			
				commonElements.add(getHead(a));
				
				// Recursively step to the next one.			
				duplicateVals(getTail(a), getTail(b), commonElements);
				
			} else if (getHead(a) < getHead(b)) {
				
				duplicateVals(getTail(a), b, commonElements);
				
			} else { // if getHead(a) > getHead(b) 
				
				duplicateVals(a, getTail(b), commonElements);
			}
			
			// Finally, we can return the common elements as an ArrayList.
			return new ArrayList<Integer>(commonElements);
		}
	}

	/**
	 * This public method returns a List of Integers that are the common elements of the two Lists 'a' and 'b'. A set is
	 * used so that duplicate values are not stored. 
	 * 
	 * Precondition(s): Both List implementations of a and b MUST already be sorted in ascending order.
	 * 
	 * @param a is a sorted (ascending) list of integers.
	 * @param b is a sorted (ascending) list of integers.
	 * @return Returns a sorted list of integers that are the common elements of both List 'a' and List 'b'.
	 */
	public static List<Integer> duplicateVals(List<Integer> a, List<Integer> b) {
		
		SortedSet<Integer> commonElements = new TreeSet<>();
		
		return duplicateVals(a, b, commonElements);
	}
}
