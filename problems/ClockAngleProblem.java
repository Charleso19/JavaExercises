package problems;

/**
 * An exercise per the MSc Computer Science course. Exercise was created via Manfred Kerber and Alexandros Evangelidis,
 * 1st October 2019, from the School of Computer Science, University of Birmingham.
 * 
 * "a) Assume we represent the time such as 11:49 by two variables hours and minutes, that is,hours= 11; and minutes = 49;.
 * 	   Write a Java method public static int timeToAngle(int hours,int minutes)that computes the angle between the hour hand
 * 	   and the minute hand on a traditional analogue clock. Angles should be measured counterclockwise from hour to minute
 *     hand. The result should be rounded and normalized so that it is an int between 0 and 359 (inclusively). For instance,
 *     the angles at 3:00 and 9:00 hours should be 90◦and 270◦, respectively.
 * 
 *     "(Hint: 1 minute approx. equals 6◦, 1 hour approx. equals 30◦. Start from 12 o’clock.)
 *     Note that your program must be able to compute the output for arbitrary inputs, in which hours may take values from
 *     0 through 24 and minutes from 0 to 60. Furthermore, note that the hour hand moves also when the minute hand moves,
 *     for instance, at 0:20 the hour hand will have moved by 10◦.
 * 
 *     "Test your program for the following times: 9:00, 3:00, 18:00, 1:00, 2:30, and 4:41 (with results 270◦, 90◦, 180◦,
 *      30◦, 255◦, and 255◦, respectively).
 * 
 * "b) Extend your program so that a third variable seconds takes the corresponding seconds. The program should still
 *     compute the angle between the hour hand and the minute hand. Test it for 0:00:20 and 13:05:27.272727272727 (with
 *     results 358◦and 0◦, respectively)."
 * 
 * @author Owen Charles
 * @version 2020/11/11
 */
public class ClockAngleProblem {

	/**
	 * The timeToAngle Method converts the time of an analogue clock to an angle from the hour-hand to the minute-hand,
	 * anti-clockwise.
	 *  
	 * @param hours is the hours of the clock.
	 * @param minutes is the minutes of the clock.
	 * @param seconds is the seconds of the clock.
	 * @return The angle of the analogue clock.
	 */
	public static int timeToAngle(int hours, int minutes, double seconds) {
		
		// The modulus is taken to cater for the 24 hour-style of the input. 
		hours = hours % 12;
		
		int hoursAngle      = (int) Math.round((0.5 * minutes) + (30 * hours));
		double minutesAngle = (0.1 * seconds) + (6 * minutes)				  ;
		
		// z is the angle from the minutes-hand to the perpendicular 12 o'clock position, clockwise.
		double z = 360 - minutesAngle;

		return (int) (hoursAngle + z) % 360;
		
	}
	
	
	public static void main(String[] args) {
		
		// Tests for hours and minutes only.
		System.out.println(timeToAngle( 9, 00, 00));
		System.out.println(timeToAngle( 3, 00, 00));
		System.out.println(timeToAngle(18, 00, 00));
		System.out.println(timeToAngle( 1, 00, 00));
		System.out.println(timeToAngle( 2, 30, 00));
		System.out.println(timeToAngle( 4, 41, 00));
		
		// Tests that include seconds.
		System.out.println(timeToAngle(0, 00, 20.0));
		System.out.println(timeToAngle(13, 05, 27.272727272727));
		
	}
}
