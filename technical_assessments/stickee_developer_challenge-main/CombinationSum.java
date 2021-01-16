import java.util.ArrayList;
import java.util.List;

/**
 * This class is a slightly modified version of cherryljr's solution for Leetcode's CombinationSum challenge
 * (see citations).
 * 
 * The solution for the WallysWidget's challenge involves first checking whether any combination of packages can equal
 * the ordered amount of widgets exactly. This class achieves this via the combinaionSum method, returning all possible
 * combinations. If there are no combinations that equal the widget order, then an empty List of List of Integers 
 * (List<List<Integer>>) is returned, in which case, phase two of the algorithm is activated.
 * 
 * CITATIONS: https://github.com/cherryljr/LeetCode/blob/master/Combination%20Sum.java
 * 			  https://leetcode.com/problems/combination-sum/
 * 
 * @author Owen Charles
 * @version 2020/12/13
 */
public class CombinationSum {
	
	/**
	 * 
	 * @param PACKAGES is the int array that contains the packages available to be ordered.
	 * 
	 * @param ORIGINAL_WIDGET_ORDER is the amount of widgets that were originally ordered by the customer.
	 * 
	 * @return A List<List<Integer>> representing all combinations of PACKAGES that equal the original widget order.
	 */
	public static List<List<Integer>> combinationSum(final int[] PACKAGES, final int ORIGINAL_WIDGET_ORDER) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		if (PACKAGES.length == 0) {
			
			return result;
		
		} else {

			depthFirstSearch(result, new ArrayList<>(), PACKAGES, 0, ORIGINAL_WIDGET_ORDER);
			return result;
		}
	}

	/**
	 * A helper method for the combinationSum method. The method represents a depth-first search algorithm.
	 * 
	 * @param result The List<List<Integer>> variable representing all combinations of PACKAGES that equal the original
	 * 		  widget order.
	 *   
	 * @param list The List<Integer> type used to store the combinations of PACKAGES that equal the original widget
	 * 		  order.
	 * 
	 * @param PACKAGES is the int array that contains the packages available to be ordered.
	 * 
	 * @param startIndex Is of type int and is the starting index.
	 * 
	 * @param remainTarget The amount of widgets left to order.
	 */
	private static void depthFirstSearch(List<List<Integer>> result, List<Integer> list, int[] PACKAGES,
											int startIndex, int remainTarget) {
		if (remainTarget == 0) {
			result.add(new ArrayList<>(list));
			return;
		
		} else {

			for (int i = startIndex; i < PACKAGES.length; i++) {
				
				if (PACKAGES[i] > remainTarget) {
					break;
				}
				
				list.add(PACKAGES[i]);
				depthFirstSearch(result, list, PACKAGES, i, remainTarget - PACKAGES[i]);
				list.remove(list.size() - 1);
			}
		}
	}
}