package problems;

import java.util.Arrays;

/**
 * A solution to the Single Number problem on leedcode.com: 
 * 
 * "Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 * 
 * "Preconditions: 
 *  1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once."
 * 
 * The solution sorts the array into ascending order and utilises two pointers to linearly progress through the array.

 * @author Owen Charles
 * @version 2020/11/14
 */
public class SingleNumber {

	/**
	 * The method identifies and returns the element that only appears once in the array.
	 * 
	 * @param nums is the int array that contains the single element that is to be returned.
	 * @return the int that only appears once in the int array.
	 */
	public int singleNumber(int[] nums) {

		/* The nums array is sorted so that we can be certain a possible second int is not found further on in the
		 * array.
		 */
		Arrays.sort(nums);

		// j is the second pointer, used to compare with the ith element. 
		int j;

		for (int i = 0; i < nums.length; i++) {

			j = i + 1;
			
			/* If j is out of bounds for the nums array, then the missing number must be the last entry, that is
			 * nums[i].
			 */
			if (j >= nums.length) {

				return nums[i];

			/* Else if the two elements of pointer i and j are to not equal, then the single number is at position
			 * nums[i].
			 */
			} else if (nums[i] != nums[j]) {

				return nums[i];

			/* Else, we continue to search for the single number. i becomes j before being incremented by 1 via the
			 * for loop.
			 */
			} else {

				i = j;
			}
		}

		// -1 is returned if the precondition is violated.
		return -1;
	}

	public static void main(String[] args) {
		
		// Example test cases via leetcode.
		int[] testCaseOne   = {2, 2, 1}; 		// output = 1;
		int[] testCaseTwo   = {4, 1, 2, 1, 2};  // output = 4;
		int[] testCaseThree = {1}; 			    // output = 1;
		
		SingleNumber singleNumberInstance = new SingleNumber();
		
		System.out.println(singleNumberInstance.singleNumber(testCaseOne));
		System.out.println(singleNumberInstance.singleNumber(testCaseTwo));
		System.out.println(singleNumberInstance.singleNumber(testCaseThree));
		
	}
}
