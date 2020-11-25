
public abstract class Item {
	
	// Price is in British Pound Sterling
	private double price;
	private String name;
	private double discountPercentage;
	
	public Item(double price, String name, double discountPercentage) {
		
		checkDiscount(discountPercentage);
		
		this.price = price;
		this.name = name;
		this.discountPercentage = discountPercentage;
		
	}
	
	/* A helper method to ensure that the discount for the specific item is
	 * within the constraints set in the specification. A helper method has
	 * been used as the constructor and the method setDiscountPercentage would
	 * both need to implement this check; the use of a helper method reduces
	 * repetitive code and increases the modularity of the program. For example,
	 * if the constraints of the discount were to be changed, it would only have
	 * to be altered in a single place in the program, rather than two.
	 * 
	 * Furthermore, each subclass of Item inherits the check, thus further
	 * reducing repetitive code.
	 */
	public void checkDiscount(double discountPercentage) {
		
		if (discountPercentage < 0 || discountPercentage >= 100) {

			throw new IllegalArgumentException("The discount must be between 0 "
					+ "(inclusive) and 100 (exclusive)");
			
		}
	}
	
	// Applies the discount to the item and updates the price.
	public void applyDiscount() {
		
		setPrice(getPrice() - ((getDiscountPercentage() / 100.0) * getPrice()));
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDiscountPercentage(double discountPercentage) {
		
		checkDiscount(discountPercentage);
		
		this.discountPercentage = discountPercentage;
	}

	@Override
	public String toString() {
		
		return String.format(
					 "Type of item: %s%n"
				+    "Name: %s%n"
				+ 	 "Price: %.2f%n"
				+    "Discount: %.2f%%%n", getClass().getSimpleName(),
										   getName()				 ,
										   getPrice()				 ,
										   getDiscountPercentage())  ;
	}
}
