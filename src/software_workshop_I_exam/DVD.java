
public class DVD extends Item {

	/* playingTime is of an int type to represent minutes; films represented in
	 * minutes is the standard in the industry.
	 */
	private int playingTime;
	
	public DVD(double price, String name,
			   double discountPercentage, int playingTime) {
		
		super(price, name, discountPercentage);
		
		this.playingTime = playingTime;
		
	}

	public int getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}

	@Override
	public String toString() {
		
		return super.toString() + String.format("Playing time: %s minutes%n",
												 getPlayingTime());
	}
}