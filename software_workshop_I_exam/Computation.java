
public class Computation {

	
	public static double[] generateTestValues(int n, double a, double b) {
		
		// Assumption: 'a' is inclusive and 'b' is exclusive.
		
		if (a > b || n < 0) {
			
			throw new IllegalArgumentException("Invalid arguments were passed "
					+ "to the method 'generateTestValues'.");
					   
			
		} else {
			
			double[] testValues = new double[n];
			
			for (int i = 0; i < n; i++) {
				
				/* Citation: Manfred Kerber, 2018-11-24, DisplayBarChart.java.
				 * 			 This formula was originally developed by Manfred
				 * 			 Kerber. I have altered the variable names and
				 * 			 the resulting assignment.
				 */
				testValues[i] = (a + (b - a) * Math.random());
				
			}
			
			return testValues;
		}
	}
		
	
	public static void main(String[] args) {
		
		// Tests based on a decision-coverage and boundary analysis framework.
		double[] aGreaterThanB = generateTestValues(20, 40, 13);
		double[] nIsNegative = generateTestValues(-1, 10, 30);
		double[] nIsZero = generateTestValues(0, 20, 100);
		double[] negRange = generateTestValues(10000, -10, 10);

	}
}
