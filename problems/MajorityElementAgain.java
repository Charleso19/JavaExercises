import java.util.Arrays;

/**
 * This solution was provided by Leetcode. It has worse time complexity (O(n log
 * n)), but is simple.
 * 
 * @author Leetcode
 * @version Unknown
 */
public class MajorityElementAgain {

	public int majorityElement(int[] nums) {

		// Arrays.sort() typically has O(n log n) time complexity
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {

		MajorityElementAgain majEleAgaInstance = new MajorityElementAgain();

		int[] testCaseOne = { 3, 2, 3 };
		int[] testCaseTwo = { 2, 2, 1, 1, 1, 2, 2 };
		int[] testCaseThree = { -1, 1, 1, 1, 2, 1 };

		System.out.println(majEleAgaInstance.majorityElement(testCaseOne));
		System.out.println(majEleAgaInstance.majorityElement(testCaseTwo));
		System.out.println(majEleAgaInstance.majorityElement(testCaseThree));
	}

}
