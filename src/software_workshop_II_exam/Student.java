
/* This class was created on the specification provided in the 2020 exam booklet
 * and is the Student class that the Teams class interacts with.
 */
public class Student implements Comparable<Student> {
	
	private int    idNumber ;
	private String lastName ;
	private String firstName;
	private String teamName ;
	
	public Student(int idNumber, String lastName, String firstName,
											      String teamName) {
		
		this.idNumber  = idNumber ;
		this.lastName  = lastName ;
		this.firstName = firstName;
		this.teamName  = teamName ;
		
	}

	public int getIdNumber() {
		return idNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	/* Students are to be sorted via their last name first and then their first
	 * name. 
	 */
	@Override
	public int compareTo(Student other) {
		
		if (this.getLastName().compareTo(other.getLastName()) == 0) {
			
			return this.getFirstName().compareTo(other.getFirstName());
		
		} else { // Else, if their last names are not identical.
			
			return this.getLastName().compareTo(other.getLastName());
		}
	}

	@Override
	public String toString() {
		
		return getFirstName() + " " + getLastName();
	}
}
