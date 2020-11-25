public class Recursion {
	
	// This method requires the List.java class in order to function
	static List<Integer> unique(List<Integer> a, List<Integer> b) {
		
		// Base case 01:
		if (a.isEmpty()) {
			
			return b;
		
		  // Base case 02:
		} else if (b.isEmpty()) {
			
			return a;
		
		 // Recursive step:
		} else if (a.getHead() < b.getHead()) {
			
			return new List<>(a.getHead(), unique(a.getTail(), b));
			
		} else if (a.getHead() > b.getHead()) {
			
			return new List<>(b.getHead(), unique(a, b.getTail()));
			
		} else { // a.getHead() == b.getHead()
			
			return unique(a.getTail(), b.getTail());
		}
	}

	// The main method contains the 10 tests via part (a) Testing.
	public static void main(String[] args) {
		
		// 10 Tests:  
		List<Integer> a1 = new List<>();
		List<Integer> b1 = new List<>(1, new List<>(2, new List<>(3, new List<>())));
		
		List<Integer> a2 = new List<>(1, new List<>(2, new List<>(3, new List<>())));
		List<Integer> b2 = new List<>();
		
		List<Integer> a3 = new List<>();
		List<Integer> b3 = new List<>();
		
		List<Integer> a4 = new List<>(1, new List<>(2, new List<>(3, new List<>())));
		List<Integer> b4 = new List<>(4, new List<>(5, new List<>(6, new List<>())));
		
		List<Integer> a5 = new List<>(4, new List<>(5, new List<>(6, new List<>())));
		List<Integer> b5 = new List<>(1, new List<>(2, new List<>(3, new List<>())));
		
		List<Integer> a6 = new List<>(1, new List<>(4, new List<>(6, new List<>()))); 
		List<Integer> b6 = new List<>(5, new List<>(6, new List<>(9, new List<>())));
		
		List<Integer> a7 = new List<>(-6, new List<>(-5, new List<>(-4, new List<>())));
		List<Integer> b7 = new List<>(-3, new List<>(-2, new List<>(-1, new List<>())));
		
		List<Integer> a8 = new List<>(-2, new List<>(-1, new List<>(0, new List<>())));
		List<Integer> b8 = new List<>(-1, new List<>(0, new List<>(1, new List<>(2, new List<>()))));
		
		List<Integer> a9 = new List<>(-1, new List<>(0, new List<>(1, new List<>())));
		List<Integer> b9 = new List<>(3, new List<>(4, new List<>(5, new List<>())));
		
		List<Integer> a10 = new List<>(-1, new List<>(0, new List<>(1, new List<>())));
		List<Integer> b10 = new List<>(-1, new List<>(0, new List<>(1, new List<>())));
		
		System.out.println(unique(a1, b1));
		System.out.println(unique(a2, b2));
		System.out.println(unique(a3, b3));
		System.out.println(unique(a4, b4));
		System.out.println(unique(a5, b5));
		System.out.println(unique(a6, b6));
		System.out.println(unique(a7, b7));
		System.out.println(unique(a8, b8));
		System.out.println(unique(a9, b9));
		System.out.println(unique(a10, b10));
		
	}
}
