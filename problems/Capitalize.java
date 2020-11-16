/**
 * A problem found via a small coding assignment. The class capitalises each word of a phrase.
 * 
 * Precondition: The phrase must NOT contain any punctuation.
 * 
 * @author Owen Charles
 * @version 2020/11/15
 */
public class Capitalize {
	
	/**
	 * @param phrase is the String to be capitalised
	 * @return the phrase but each word is capitalised. 
	 */
	public static String capitalize(String phrase) {

		// Split the words into an array.
		String[] arrayOfWords = phrase.split(" ");

		for (int i = 0; i < arrayOfWords.length; i++) {

			/* We then iterate over each word in the array, capitalise it's first letter and
			 * concatenate it with the rest of the String. We then rewrite this new
			 * concatenated String back to its original position.
			 */
			arrayOfWords[i] = arrayOfWords[i].substring(0, 1).toUpperCase() + arrayOfWords[i].substring(1);
		}

		// Finally, we rejoin the altered Strings into the original phrase, and return it.
		return String.join(" ", arrayOfWords);

	}

	public static void main(String[] args) {
		
		System.out.println(capitalize("hello world"));
		System.out.println(capitalize("How are you"));

	}

}
