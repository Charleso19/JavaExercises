import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing for the CommonValuesRecursive class.
 * 
 * @author Owen Charles
 * @version 2020/09/11
 */
public class CommonValuesRecursiveTest {
	
	// getHead method test case instance variables
	private List<Integer> headTestCaseOne, headTestCaseTwo, headTestCaseThree, headTestCaseFour;
	
	
	// getTail method test case instance variables
	private List<Integer> tailTestCaseOne, tailTestCaseTwo, tailTestCaseThree, tailTestCaseFour;
	
	// dupllicateVals method test case instance variables
	private List<Integer> a, b, c, d, e, f, g, h, i, j;

	@BeforeEach
	public void initiateTestData() {
		
		// getHead test cases		
		headTestCaseOne   = new ArrayList<>(Arrays.asList());
		headTestCaseTwo   = new ArrayList<>(Arrays.asList(2, 3, 4));
		headTestCaseThree = new ArrayList<>(Arrays.asList(0));
		headTestCaseFour  = new ArrayList<>(Arrays.asList(-1, 0, 1));
		
		// getTail test cases - 100% decision coverage.
		tailTestCaseOne = new ArrayList<>(Arrays.asList());
		tailTestCaseTwo = new ArrayList<>(Arrays.asList(-5));
		tailTestCaseThree = new ArrayList<>(Arrays.asList(-1, 0));
		
		//getTail normal test case
		tailTestCaseFour = new ArrayList<>(Arrays.asList(2, 5, 7));
		
		// duplicateVals test cases
		// Initial test case
		a = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89            ));
		b = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5,  6,  7,  8,  9, 10, 11, 12, 13));
		
		// Duplicate
		c = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
		d = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
		
		// Singletons 
		e = new ArrayList<>(Arrays.asList(5));
		f = new ArrayList<>(Arrays.asList(4));
		
		// More in one than the other
		g = new ArrayList<>(Arrays.asList(1, 2));
		h = new ArrayList<>(Arrays.asList(1   ));
		
		// Mix of negative and positive
		i = new ArrayList<>(Arrays.asList(-2, -1, 0, 1, 2));
		j = new ArrayList<>(Arrays.asList(-1,  0, 2, 6, 8));
		
	}
	
	@Test
	public void testGetHead() {
		
		assertThrows(IllegalArgumentException.class, () -> {CommonValuesRecursive.getHead(headTestCaseOne);});
		assertEquals(2, CommonValuesRecursive.getHead(headTestCaseTwo));
		assertEquals(0, CommonValuesRecursive.getHead(headTestCaseThree));
		assertEquals(-1, CommonValuesRecursive.getHead(headTestCaseFour));
	}
	
	@Test
	public void testGetTail() {
		
		assertThrows(IllegalArgumentException.class, () -> {CommonValuesRecursive.getTail(tailTestCaseOne);});
		assertEquals(Arrays.asList(), CommonValuesRecursive.getTail(tailTestCaseTwo));
		assertEquals(Arrays.asList(0), CommonValuesRecursive.getTail(tailTestCaseThree));
		assertEquals(Arrays.asList(5, 7), CommonValuesRecursive.getTail(tailTestCaseFour));
	}
	
	@Test
	public void testDuplicateVals() {
		
		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 8, 13)), CommonValuesRecursive.duplicateVals(a, b));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 8, 13)), CommonValuesRecursive.duplicateVals(b, a));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), CommonValuesRecursive.duplicateVals(c, d));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), CommonValuesRecursive.duplicateVals(d, c));
		assertEquals(new ArrayList<Integer>(Arrays.asList()), CommonValuesRecursive.duplicateVals(e, f));
		assertEquals(new ArrayList<Integer>(Arrays.asList()), CommonValuesRecursive.duplicateVals(f, e));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1)), CommonValuesRecursive.duplicateVals(g, h));
		assertEquals(new ArrayList<Integer>(Arrays.asList(1)), CommonValuesRecursive.duplicateVals(h, g));
		
		assertEquals(new ArrayList<Integer>(Arrays.asList(-1, 0, 2)), CommonValuesRecursive.duplicateVals(i, j));
	}

}
