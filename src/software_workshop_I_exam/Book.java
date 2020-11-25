
public class Book extends Item {
	
	/* The instance variable is of type int in order to represent the real-world
	 * object.
	 */
	private int numberOfPages;
	
	public Book(double price, String name,
			    double discountPercentage, int numberOfPages) {
		
		super(price, name, discountPercentage);
		
		this.numberOfPages = numberOfPages;
		
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		
		return super.toString() + String.format("Number of pages: %d%n",
											     getNumberOfPages());
	}
}
