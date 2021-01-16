import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The WallysWidgets class is a Java solution for the Wally's Widgets problem as part of the Stickee Developer
 * Challenge. The solution is a 'standalone' class and can be run via the main method within this class.
 * 
 * The solution is consistent with the following logic:
 *  
 *  1. Only whole packs can be sent. Packs cannot be broken open.
 *  
 *	2. Within the constraints of Rule 1 above, send out no more widgets than necessary to fulfil
 *	   the order.
 *
 *	3. Within the constraints of Rules 1 and 2 above, send out as few packs as possible to fulfil each
 *	   order.
 * 
 * 
 * Precondition 1: The int array 'PACKAGES' MUST be sorted in descending order.
 * Precondition 2: The values inside the int array 'PACKAGES' MUST NOT be 0 or a negative number.
 * Precondition 3: ORIGINAL_WIDGET_ORDER MUST be above 0. That is to say, one cannot order 0 or a negative number of
 * 				   widgets.
 * 
 * 
 * Algorithmic abstraction:
 * 
 * 				Can the widget order be fulfilled by a combination
 * 				         of the available packages?
 *					  /              	\
 *			             yes /  			 \ no		
 * 	  			        /    			  \
 *	  			       /      			   \
 * 		              Return the combination          Attempt to find the selection
 *      		       that uses the least		of packages that uses the 
 * 	                       amount of packages.	       minimum amount of widgets and
 *                                                            packages necessary (rule 2 and 3).
 * 
 * 
 * 
 * A note on flexibility:
 * 
 * The programmer need only change the PACKAGES variable (main method) to meet the flexibility requirements of the
 * challenge; one can add/delete packages and/or adjust package sizes. The amount of widgets that the programmer/user
 * wishes to order can be altered via modifying the ORIGINAL_WIDGET_ORDER variable (main method).
 * 
 * 
 * Evaluation:
 * 
 * The procedural-style of the class allows for simplicity and minimal alterations if one wishes to change how many
 * packages there are available to order or their size. However, in order to aid extensibility, I would transform the
 * program from a Procedural paradigm to an Object-Oriented one. For example, the WallysWidgets class could be composed
 * of (has-a) a List of Package instances. This would allow for extra details to be added to the packages, such as
 * price for example.
 * 
 * @author Owen Charles
 * @version 2020/12/12
 */
public class WallysWidgets {
	
	/**
	 * The method collectWidgets is the algorithmic workhorse of the program. Essentially, it attempts to fulfil the
	 * order via the minimum amount of widgets necessary (rule 2) via the least amount of packages (rule 3). In some
	 * cases, either of the rules can be broken, in which case a second call to the method refines the order.
	 * 
	 * @param  PACKAGES is the int array that contains the packages available to be ordered.  
	 * 
	 * @param  WIDGET_ORDER is the original number of widgets ordered.
	 * 
	 * @return The minimum amount of widgets necessary that will fulfil the order based on the pack sizes.
	 */
	public static int[] collectWidgets(final int[] PACKAGES, final int WIDGET_ORDER) {
		
		final int[] PACKAGES_TO_ORDER = new int [PACKAGES.length]       ;
		List<Integer> differences     = new ArrayList<>(PACKAGES.length);		
		
		int widgetsLeftToOrder = WIDGET_ORDER;
		
		// While there are still widgets left to order.
		while (widgetsLeftToOrder > 0) {
			
			/* If the amount of widgets still left to order is larger than the amount of widgets in the largest pack,
			 * then add the largest pack and subtract the widgets in the largest pack from the widgets left to order.
			 */
			if (widgetsLeftToOrder >= PACKAGES[0]) {
				
				PACKAGES_TO_ORDER[0]++;
				widgetsLeftToOrder -= PACKAGES[0];
				continue;
			
			/* Else, we select the pack of widgets that has the smallest absolute difference compared to the widgets
			 * left to order.
			 */
			} else {
			
				for (int pack : PACKAGES) {
					
					differences.add(Math.abs(widgetsLeftToOrder - pack));
					
				}
				
				int smallestPackPosition = differences.indexOf(Collections.min(differences));
				PACKAGES_TO_ORDER[smallestPackPosition]++;
				widgetsLeftToOrder -= PACKAGES[smallestPackPosition];
				
				// The List is cleared for the next iteration.
				differences.clear();
			}
		}
		
		return PACKAGES_TO_ORDER;
		
	}
	
	/**
	 * Helper method that sums up all the widgets in the packs selected for delivery.
	 * 
	 * 
	 * @param  PACKAGES is the int array that contains the packages available to be ordered. 
	 * 
	 * @param  packagesForDeliver is the int array representing which and how many packs are for delivery.
	 * 
	 * @return An int value representing the sum of all the widgets in the packages that have been selected for
	 *         delivery.
	 */
	private static int sum(final int[] PACKAGES, int[] packagesForDelivery) {
		
		int widgets = 0;
		
		for (int i = 0; i < packagesForDelivery.length; i++) {
		
			widgets += packagesForDelivery[i] * PACKAGES[i]; 
		}
		
		return widgets;
		
	}
	
	/**
	 * A helper method that sums up the amount of packages in an order.
	 * 
	 * @param  packagesForDeliver is the int array representing which and how many packs are for delivery.
	 * 
	 * @return The amount of packages in an order.
	 */
	private static int sumPacks(int[] packagesForDelivery) {
		
		int packs = 0;
		
		for (int i = 0; i < packagesForDelivery.length; i++) {
			
			packs += packagesForDelivery[i];
			
		}
		
		return packs; 
	}
	
	/**
	 * The method orderWidgets is coupled with the collectWidgets method, and essentially decides which array of
	 * packages to return based on the logic rules 1, 2, and 3.
	 * 
	 * @param  PACKAGES is the int array that contains the packages available to be ordered. 
	 * 
	 * @param  ORIGINAL_WIDGET_ORDER is the amount of widgets that were originally ordered by the customer.
	 * 
	 * @return An int array representing the packages that fulfil the order.
	 */
	public static int[] orderWidgets(final int[] PACKAGES, final int ORIGINAL_WIDGET_ORDER) {
		
		
		// Rule 2: The minimum number of widgets (based on the packages available) to fulfil the order are calculated.
		int[] minimumWidgetsOrder       = collectWidgets(PACKAGES, ORIGINAL_WIDGET_ORDER);
		int totalWidgetsForMinimumOrder = sum(PACKAGES, minimumWidgetsOrder)             ;
		
		
		/* Rule 3: The package order is refined as the minimum number of widgets necessary to fulfil the order may be
		 * 		   able to be reorganised so that less packages are used.
		 */
		int[] refinedOrder 			 = collectWidgets(PACKAGES, totalWidgetsForMinimumOrder);
		int totalWidgetsRefinedOrder = sum(PACKAGES, refinedOrder)					;

		// If the refinement order has broken rule 2, then go with the initial minimumWidgetsOrder.
		if (totalWidgetsForMinimumOrder < totalWidgetsRefinedOrder) {

			return minimumWidgetsOrder;

		/* Else, if the original and refinement procedure both have the same number of widgets; choose the one with the
		 * less packs (rule 3).
		 */
		} else if (totalWidgetsForMinimumOrder == totalWidgetsRefinedOrder) {

			int sumOfPacksForMinimumWidgetsOrder = sumPacks(minimumWidgetsOrder);
			int sumOfPacksForRefinedOrder        = sumPacks(refinedOrder       );

			if (sumOfPacksForMinimumWidgetsOrder < sumOfPacksForRefinedOrder) {

				return minimumWidgetsOrder;

			} else {

				return refinedOrder;

			}

		// Else, the refinement has used less widgets than the original, and thus the refinement is returned.
		} else {
			
			return refinedOrder;
		}
	}
	
	/**
	 * Prints out the packages that are to be ordered to fulfil the order.
	 * 
	 * @param PACKAGES is the int array that contains the packages available to be ordered.
	 * 
	 * @param PACKAGES_TO_ORDER is the int array that contains the packages that are to be ordered to fulfil the order.
	 * 
	 * @param ORIGINAL_WIDGET_ORDER is the amount of widgets that were originally ordered by the customer.
	 */
	public static void printOrder(final int[] PACKAGES, final int[] PACKAGES_TO_ORDER,
								  final int ORIGINAL_WIDGET_ORDER) {
		
		System.out.println("User ordered: " + ORIGINAL_WIDGET_ORDER + " widgets.");
		for (int i = 0; i < PACKAGES_TO_ORDER.length; i++) {

			System.out.printf("%4d x %d%n", PACKAGES[i], PACKAGES_TO_ORDER[i]);

		}
	}
	
	/**
	 * Prints out the packages that are to be ordered to fulfil the order.
	 * 
	 * @param allPossibleCombinations is a List<List<Integer>> representing all possible combinations of PACKAGES that
	 * 		  fulfil the original widget order.
	 *  
	 * @param ORIGINAL_WIDGET_ORDER is the amount of widgets that were originally ordered by the customer.
	 */
	public static void printOrder(List<List<Integer>> allPossibleCombinations, final int ORIGINAL_WIDGET_ORDER) {

		List<Integer> packageOrder = allPossibleCombinations.get(allPossibleCombinations.size() - 1);
		Set<Integer> distinctSetPackages = new HashSet<>(packageOrder);
		
		System.out.println("User ordered: " + ORIGINAL_WIDGET_ORDER + " widgets.");

		for (Integer element : distinctSetPackages) {

			int occurrences = Collections.frequency(packageOrder, element);

			System.out.printf("%4d x %d%n", element, occurrences);
		}
	}
	
	/**
	 * The driver method that fulfils the order.
	 * 
	 * @param PACKAGES is the int array that contains the packages available to be ordered.
	 * 
	 * @param ORIGINAL_WIDGET_ORDER is the amount of widgets that were originally ordered by the customer.
	 */
	public static void order(final int[] PACKAGES, final int ORIGINAL_WIDGET_ORDER) {
		
		// An ascending version of PACKAGES is necessary for the CombinationSum.combinationSum method.
		final int[] PACKAGES_ASCENDING = Arrays.copyOf(PACKAGES, PACKAGES.length);
		Arrays.sort(PACKAGES_ASCENDING);

		// First we check whether the widget order can be fulfilled by a combination of the PACKAGES.
		List<List<Integer>> allPossibleCombinations =
				CombinationSum.combinationSum(PACKAGES_ASCENDING, ORIGINAL_WIDGET_ORDER);
		
		/* If there were no combination of the packages could equal the original widget order, then we aim to send out
		 * no more widgets than necessary to fulfil the order, whilst also minimising the packs sent out. 
		 */
		if (allPossibleCombinations.size() == 0) {
			
			final int[] finalOrderWidgets = orderWidgets(PACKAGES, ORIGINAL_WIDGET_ORDER);
			
			printOrder(PACKAGES, finalOrderWidgets, ORIGINAL_WIDGET_ORDER);
		
		 /* Else, if there is at least one combination of packages that add up exactly to the order, then we select the
		  * one with the least packages and print it to the console.
		  */
		} else {
			
			printOrder(allPossibleCombinations, ORIGINAL_WIDGET_ORDER);
		}
		
	}

	/* The main method is responsible for initialising the packages that the widget order is based on, and the widgets
	 * the customer wishes to order. The method then runs the code via the order method.
	 */
	public static void main(String[] args) {
		
		/*
		 * The PACKAGES and ORIGINAL_WIDGET_ORDER variables can be changed by the programmer to order different amounts
		 * of widgets and/or use different packages.
		 * 
		 * N.B. The preconditions are reiterated again here to ensure adherence:
		 * 
		 *     Precondition 1: The int array 'PACKAGES' MUST be sorted in descending order.
		 * 
		 *     Precondition 2: The values inside the int array 'PACKAGES' MUST NOT be 0 or a
		 * 				       negative number.
		 * 
		 *     Precondition 3: ORIGINAL_WIDGET_ORDER MUST be above 0. That is to say, one cannot order 0 or a negative
		 * 				       number of widgets.
		 */
		final int[] PACKAGES = { 5000, 2000, 1000, 500, 251, 250 };
		final int ORIGINAL_WIDGET_ORDER = 751;
		
		order(PACKAGES, ORIGINAL_WIDGET_ORDER);
	}
}
