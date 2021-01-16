import java.util.ArrayList;
import java.util.List;

/* Justification of design decisions:
 * 
 * The rudimentary class OnlineShop has an association with the separate 
 * inheritance-style class structure composed of Item, DVD, and Book.
 * 
 * OnlineShop ------>  Item
 * 					 {absract}
 *					  /      \
 *                  DVD      Book
 * 
 * I have designed the program via inheritance fundamentally to reduce
 * repetitive code within the classes. As the DVD and Book classes share many
 * properties and attributes, it is good software engineering practice for them
 * to inherit their common attributes and behaviours from a base class. This
 * removes the necessity to duplicate their identical code, thus reducing
 * the chance of error. Moreover, changes to their common behaviours and
 * properties can be altered in a single location (i.e. the Item base case),
 * thus increasing the modularity and maintainability characteristics of the
 * program. These software qualities are essential for the rudimentary program,
 * as these early design decisions reduce the difficulty for implementing future
 * functionality.
 * 
 * Moreover, I have designed the Item class to be abstract as a user/customer
 * should not be able to directly purchase an 'Item' from the store, but must
 * instead purchase a DVD or a Book. Therefore, an Item should not be directly
 * initialised as it is not something a customer/user can directly interact
 * with.
 * 
 * Furthermore, I have decide to implement an abstract class instead of
 * an interface for a few key reasons:
 * 
 * 1) Extending the functionality of the program will require less work, as one
 * can simply adapt the Item class and its subsequent sub-classes will inherit
 * the new functionality. The use of an interface would require all sub-classes
 * to be altered.
 * 
 * 2) The abstract class fits well with the intuitive inheritance concept of
 * the classes, i.e. a Book and DVD is-a Item.
 * 
 * 3) As both DVD and Book class share common functionality/implementation, it
 * is better to inherit the identical behaviour from the abstract class, rather
 * than force each class to implement identical code via an interface.
 * 
 * An additional justification of one's design decisions is the use of two
 * instance variables in OnlnieShop: one for DVD and one for Book. Although
 * one could technically add both to a List of Item (List<Item>), this may
 * cause an issue if we are unsure of which object is at which position, 
 * as we may select a DVD instant by accident and attempt to call the
 * getNumberOfPages() method, resulting in an Exception. Therefore, to reduce
 * the error, I have decided to separate DVD and Book into their own
 * respective lists.
 * 
 * Please also see the comments throughout each class for further specific 
 * justifications of design decisions.
 */

public class OnlineShop {

	/* camelCase convention has been ignored for the DVDsForSale instance
	 * variable as 'DVD' improves code readability.
	 * 
	 * Moreover, as the program is rudimentary, I have adapted a 'program to the
	 * interface' design decision so that the implementation of types such as
	 * List are flexible and easily interchangeable, allowing it to be easily
	 * changed if needed in future development.
	 */
	private List<DVD>  DVDsForSale ;
	private List<Book> booksForSale;
	
	/* This is one of two constructors. I have implemented two constructors to
	 * provide greater flexibility. One may choose to initialise an empty online
	 * shop with no items only to add them later on. Or, one may initialise an
	 * online shop with items (of course, retaining the ability to add more
	 * items at a later stage).
	 */
	public OnlineShop() {
		
		/* I have decided to initialise the Lists of DVD and Book classes as 
		 * ArrayLists due to its general fast complexity and dynamic growth
		 * nature.
		 */
		DVDsForSale  = new ArrayList<DVD> ();
		booksForSale = new ArrayList<Book>();
	}
	
	/* A second constructor whereby the online shop can be initialised with
	 * pre-initialised lists of items (DVDs and Books).
	 */
	public OnlineShop(List<DVD> DVDsForSale, List<Book> booksForSale) {
		
		this.DVDsForSale  = DVDsForSale ;
		this.booksForSale = booksForSale;
	}
	
	public List<DVD> getDVDsForSale() {
		
		return DVDsForSale;
		
	}
	
	public List<Book> getBooksForSale() {
		
		return booksForSale;
		
	}
	
	/* Setters come in the form of adding and removing DVD and Book objects to
	 * the store.
	 */
	
	// Adds a single DVD instance to the list of available DVDs for sale.
	public void addDVDForSale(DVD dvdToAdd) {
		
		getDVDsForSale().add(dvdToAdd);
		
	}
	
	// Adds a single Book instance to the list of available Books for sale.
	public void addBookForSale(Book bookToAdd) {
		
		getBooksForSale().add(bookToAdd);
	}
	
	/* Removes a DVD from the OnlineStore. Possibly via a customer as part of
	 * a sale or via an administrator as the DVD is no longer for sale. If the
	 * DVD is not in the list, then null is returned.
	 */
	public DVD removeDVDForSale(String nameOfDVD) {
		
		for (int i = 0; i < getDVDsForSale().size(); i++) {
			
			/* If the name of the DVD to be removed is equal to the name of the
			 * DVD found in the list of DVDsForSale, then it is removed from
			 * the list and returned.
			 */
			if (nameOfDVD.equals(getDVDsForSale().get(i).getName())) {
				
				DVD returnDVD = getDVDsForSale().get(i);
				
				getDVDsForSale().remove(getDVDsForSale().get(i));
				
				return returnDVD;
			}
		}
		
		return null;
	}
	
	/* Removes a Book from the OnlineStore. Possibly via a customer as part of
	 * a sale or via an administrator as the Book is no longer for sale. If the
	 * DVD is not in the list, then null is returned.
	 */
	public Book removeBookForSale(String nameOfBook) {
		
		for (int i = 0; i < getBooksForSale().size(); i++) {

			/* If the name of the Book to be removed is equal to the name of the
			 * DVD found in the list of DVDsForSale, then it is removed from
			 * the list and returned.
			 */
			if (nameOfBook.equals(getBooksForSale().get(i).getName())) {

				Book bookToReturn = getBooksForSale().get(i);
				
				getBooksForSale().remove(getBooksForSale().get(i));

				return bookToReturn;
			}
		}

		return null;

	}
	
	// Main method provides examples
	public static void main(String[] args) {

		DVD myDVDOne = new DVD(2.62, "Jurassic Park", 0.00, 126);
		DVD myDVDTwo = new DVD(3.59, "The Hobbit: An Unexpected Journey", 10.00, 169);
		Book myBookOne = new Book(10.99, "IT", 20.00, 1138);
		Book myBookTwo = new Book(7.99, "1984", 15.00, 328);
		
		OnlineShop myShop = new OnlineShop();
		
		myShop.addDVDForSale(myDVDOne);
		myShop.addDVDForSale(myDVDTwo);
		myShop.addBookForSale(myBookOne);
		myShop.addBookForSale(myBookTwo);
		
		// All Items in the shop currently for sale
		myShop.getBooksForSale().forEach(System.out::println);
		myShop.getDVDsForSale().forEach(System.out::println);
		
		// Discounts applied to all items
		myShop.getBooksForSale().forEach(x -> x.applyDiscount());
		myShop.getDVDsForSale ().forEach(x -> x.applyDiscount());
		
		// All Items in the shop after discount is applied
		System.out.println("-".repeat(80));
		myShop.getBooksForSale().forEach(System.out::println);
		myShop.getDVDsForSale().forEach(System.out::println);
	
		
	}
}