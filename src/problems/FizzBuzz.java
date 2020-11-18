package problems;

import java.util.List;
import java.util.ArrayList;

/**
 * A solution to the FizzBuzz problem on www.leetcode.com
 * 
 * "Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * 
 * @author Owen Charles
 * @version 2020/11/14
 */
public class FizzBuzz {

	/**
	 * The method fizzBuzz returns a List implementation that is a list of Strings containing values representing
	 * 1 - n (inclusive); multiples of 3 are replaced with "Fizz", multiples of 5 are replaced with "Buzz", multiples of
	 * 3 AND 5 are replaced with "FizzBuzz".
	 * 
	 * input  = 15;
	 * output = ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"];
	 * 
	 * @param  n is an int representing the last number of 1 to n (inclusive).
	 * @return A List implementation containing Strings values; multiples of 3 are replaced with "Fizz", 5 "Buzz", and 
	 *         both "FizzBuzz".
	 */
	public List<String> fizzBuzz(int n) {

		List<String> list = new ArrayList<>();

		// Here, we iterate from 1 to n (inclusive). 
		for (int i = 1; i <= n; i++) {

			// If i is divisible by both 3 AND 5, we add FizzBuzz to the list.
			if (i % 3 == 0 && i % 5 == 0) {

				list.add("FizzBuzz");
			
			// Else, if i is only divisible by 3, we add Fizz to the list. 
			} else if (i % 3 == 0) {

				list.add("Fizz");

			// Else, if i is only divisible by 5, we add Buzz to the list.
			} else if (i % 5 == 0) {

				list.add("Buzz");

			// Else, i is not a multiple of 3 OR 5, and thus i is added to the list.
			} else {

				list.add(String.valueOf(i));
			}

		}

		// Finally, we return the altered list.
		return list;
	}

	public static void main(String[] args) {
		
		FizzBuzz fizzBuzzInstance = new FizzBuzz();
		
		// Test cases provided by leetcode.
		System.out.println(fizzBuzzInstance.fizzBuzz(1));
		System.out.println(fizzBuzzInstance.fizzBuzz(15));
	}
}
