import java.util.HashMap;
import java.util.Map;

/**
 * A solution for the Majority Element problem via leetcode.com:
 * 
 * "Given an array of size n, find the majority element. The majority element is the element that appears more than
 * n / 2 times.
 * 
 * "You may assume that the array is non-empty and the majority element always exist in the array."
 * 
 * Examples:
 *  
 * input : [3, 2, 3]
 * output: 3
 * 
 * input : [2, 2, 1, 1, 1, 2, 2]
 * output: 2
 * 
 * input : [-1, 1, 1, 1, 2, 1]
 * output: 1
 * 
 * Precondition: The input array must contain a 'majority element' that is defined by occurring in the input array more
 * 				 than n / 2 times, where n is the length of the input array.
 * 
 * This implementation has a O(n) (linear) worst-case time complexity.
 * 
 * @author Owen Charles
 * @version 2020/11/14
 */
public class MajorityElement {

	/**
	 * The method returns the majority element in the nums array using a Map implementation. The method iterates over
	 * the nums array and maps each element to the amount of times each element is present in the array. The method
	 * then iterates through the map and returns the element that is present more than n / 2 times.  
	 * 
	 * @param  nums is the int array that contains the majority element.
	 * @return the int that is the majority element as defined. 
	 */
	public int majorityElement(int[] nums) {
		
		/* The majority element is to be stored in an int array as a work-around for the lambda expression being unable
		 * to assign a variable outside of its scope.
		 */
		int[] majElement = new int[1];

		Map<Integer, Integer> map = new HashMap<>();

		// Iterate over nums and populate the map.
		for (int numsElement : nums) {

			// If nums element is already present in the map, then increment its value by 1.
			if (map.containsKey(numsElement)) {
				
				int value = map.get(numsElement);
				
				map.put(numsElement, value + 1);

			 // Else, add it to the map, and assign its value to 1.
			} else {

				map.put(numsElement, 1);
			}
		}
		
		/* Here we iterate through the fully populated map and identify which element is greater than n / 2. We then
		 * assign it to the majElement int array for storage, and return this element. 
		 */
		map.forEach((key, val) -> { if (val > nums.length / 2) {
								    	
										majElement[0] = key;
			
									}
								  });
		
		// The majority element is returned.
		return majElement[0];
	}

	public static void main(String[] args) {
		
		MajorityElement majEleInstance = new MajorityElement();
		
		// Example test cases provided by Leetcode.
		int[] testCaseOne   = {3, 2, 3};
		int[] testCaseTwo   = {2, 2, 1, 1, 1, 2, 2};
		int[] testCaseThree = {-1, 1, 1, 1, 2, 1};
		
		System.out.println(majEleInstance.majorityElement(testCaseOne));
		System.out.println(majEleInstance.majorityElement(testCaseTwo));
		System.out.println(majEleInstance.majorityElement(testCaseThree));
	}

}
