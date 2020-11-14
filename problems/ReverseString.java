/**
 * A solution for the Reverse String problem on leetcode.com. This problem and solution is an example of an in-place
 * algorithm with O(1) space complexity. 
 *
 * "Write a function that reverses a string. The input string is given as an array of characters char[].
 * 
 * "Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * 
 * "You may assume all the characters consist of printable ascii characters."
 * 
 * @author Owen Charles
 * @version 2020/11/14
 */
public class ReverseString {
    
    /**
     * The method returns the char array 's' reversed. 
     * 
     * @param s is the array of chars that are to be reversed.
     * @return The reversed char array 's'.
     */
    public char[] reverseString(char[] s) {
        
    	char copy;
        int j = s.length - 1;
        
        for (int i = 0; i < s.length; i++) {
            
            // If i and j are equal or have passed one another, then the swapping is complete.
            if (i >= j) {
                break;
            
            } else { // Else, there is more swapping to do. 
                
                copy = s[i]; // h
                s[i] = s[j]; // o
                s[j] = copy;
                j--;
            }
        }
        
        // The reverse of s is returned.
        return s;
    }
    
    public static void main(String[] args) {
    
    	ReverseString reverseStringInstance = new ReverseString();
    	
    	// Two example test cases that are provided via Leetcode.
    	char[] testCaseOne = {'h', 'e', 'l', 'l', 'o'};      // output = {'o', 'l', 'l', 'e', 'h'};
    	char[] testCaseTwo = {'H', 'a', 'n', 'n', 'a', 'h'}; // output = {'h', 'a', 'n', 'n', 'a', 'H'};
    	
    	System.out.println(String.valueOf(reverseStringInstance.reverseString(testCaseOne)));
    	System.out.println(String.valueOf(reverseStringInstance.reverseString(testCaseTwo)));
    }
}
