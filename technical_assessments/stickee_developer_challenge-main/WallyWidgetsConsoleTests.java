/**
 * Not the typical JUnit tests. This class orders widgets for different widget amounts with different packages. It
 * allows the programmer to see the results of some typical test cases.
 * 
 * @author Owen Charles
 * @version 2020/12/13
 */
public class WallyWidgetsConsoleTests {
	
	/**
	 * Prints out the results for the typical test cases for a PACKAGE of 5 items, typically:
	 * [5000, 2000, 1000, 500, 250].
	 */
	public static void testFivePackages() {
		
		final int[] PACKAGES = {5000, 2000, 1000, 500, 250};
		
		System.out.println("Testing the " + PACKAGES.length + " packages:");
		System.out.println("======================================");
		
		for (int pack : PACKAGES) {
			
			System.out.println(pack);
		}
		
		System.out.println("======================================");
		
		WallysWidgets.order(PACKAGES, 1);
		WallysWidgets.order(PACKAGES, 249);
		
		WallysWidgets.order(PACKAGES, 250);
		WallysWidgets.order(PACKAGES, 251);
		
		WallysWidgets.order(PACKAGES, 500);
		WallysWidgets.order(PACKAGES, 501);
		
		WallysWidgets.order(PACKAGES, 11_999);
		WallysWidgets.order(PACKAGES, 12_000);
		WallysWidgets.order(PACKAGES, 12_001);
		
	}
	
	/**
	 * Prints out the results for the typical test cases for a PACKAGE of 6 items, typically:
	 * [5000, 2000, 1000, 500, 251, 250].
	 */
	public static void testSixPackages() {
		
		final int[] PACKAGES = {5000, 2000, 1000, 500, 251, 250};
		
		System.out.println("Testing the " + PACKAGES.length + " packages:");
		System.out.println("======================================");
		
		for (int pack : PACKAGES) {
			System.out.println(pack);
		}
		System.out.println("======================================");
		
		WallysWidgets.order(PACKAGES, 1);
		WallysWidgets.order(PACKAGES, 249);
		
		WallysWidgets.order(PACKAGES, 250);
		WallysWidgets.order(PACKAGES, 251);
		
		WallysWidgets.order(PACKAGES, 500);
		WallysWidgets.order(PACKAGES, 501);
		WallysWidgets.order(PACKAGES, 502);
		
		WallysWidgets.order(PACKAGES, 751);
		WallysWidgets.order(PACKAGES, 1502);
		
		WallysWidgets.order(PACKAGES, 11_999);
		WallysWidgets.order(PACKAGES, 12_000);
		WallysWidgets.order(PACKAGES, 12_001);
		
	}
	

	public static void main(String[] args) {
		
		testFivePackages();
		testSixPackages();
		
	}

}
