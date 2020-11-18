package problems;

/**
 * The class outputs the The Twelve Days of Christmas song
 * (https://en.wikipedia.org/wiki/The_Twelve_Days_of_Christmas_(song)) via the use of the "Falling Through" feature
 * of a switch statement without break statements.
 * 
 * The following class is a solution for the exercise given by Deitel & Deitel in their 2017 "Java How to Program"
 * 11th Ed. book.
 * 
 * @author Owen Charles
 * @version 2020/11/16
 */
public class TwelveDaysChristmas {
	
	private static final String   partOne = "On the ";
	private static final String   partTwo = " day of Christmas my true love sent to me";
	private static final String[] days    = {"first", "second", "third", "fourth", "fifth", "sixth",
										     "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};

	public static void main(String[] args) {
		
		/* A for loop is used to iterate through the 12 days of Christmas. As the days are stored in an array, i must
		 * be initialised as 0. Therefore, i = 0 represents the 1st day; i = 1 represents the 2nd day; i = 3 represents
		 * the 3rd day, ..., i = 11 represents the 12th day.
		 */
		for (int i = 0; i < days.length; i++) {

			System.out.println(partOne + days[i] + partTwo);
			
			/* The cases represent the days, but due to the use of an array are 1 day less than what may be expected.
			 * Therefore, case 0 represents the 1st day; case 1 represents the 2nd day etc.
			 */
			switch (i) {
				
				case 0:
					System.out.printf("A partridge in a pear tree.%n%n");
					break;
				
				case 11:
					System.out.println("Twelve drummers drumming,");
				
				case 10:
					System.out.println("Eleven pipers piping,");
				
				case 9:
					System.out.println("Ten lords a-leaping,");
				
				case 8:
					System.out.println("Nine ladies dancing,");
				
				case 7:
					System.out.println("Eight maids a-milking,");
				
				case 6:
					System.out.println("Seven swans a-swimming,");
				
				case 5:
					System.out.println("Six geese a-laying,");
				
				case 4:
					System.out.println("FIVE GOLDEN RINGS!");
				
				case 3:
					System.out.println("Four calling birds,");
				
				case 2:
					System.out.println("Three French Hens,");
			
				case 1:
					System.out.println("Two turtle doves,");
				
				default:
					System.out.printf("And a partridge in a pear tree.%n%n");
					break; // break statement is optional but I have used it for readability purposes.
			}
		}
	}
}
