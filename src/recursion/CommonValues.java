package recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The CommonValues is an efficient class solution to the following problem: 
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
public class CommonValues {

	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89            ));
		List<Integer> b = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5,  6,  7,  8,  9, 10, 11, 12, 13));
		
		SortedSet<Integer> a1 = new TreeSet<>(a);
		SortedSet<Integer> b1 = new TreeSet<>(b);
		
		a1.retainAll(b1);
		
		System.out.println(a1);

	}

}
