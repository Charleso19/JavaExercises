import java.util.TreeMap;

/* This class requires the Student and Team classes to run, provided in the
 * submission .zip folder. 
 */
public class Teams {
	
	/* Every Teams instance is an independent manager for all Team instances
	 * stored in its TreeMap data structure. Please see part (c) of the .pdf
	 * file included in the submission for justifications of the data structure.
	 */
	private TreeMap<String, Team> teams;

	public Teams(Student[] students) {
		
		teams = new TreeMap<String, Team>();
		
		addStudentToTeam(students);
		
	}
	
	// Returns the map data structure that maps team names to Team instances.
	public TreeMap<String, Team> getTeams() {
		return teams;
	}

	// Sets a new Map data structure mapping team names to Team instances.
	public void setTeams(TreeMap<String, Team> teams) {
		this.teams = teams;
	}


	// Adds a single Student to a team
	public void addStudentToTeam(Student student) {
		
		Student[] singleStudent = new Student[1];
		singleStudent[0]= student;
		addStudentToTeam(singleStudent);
	}
	
	/* Adds all Students in the array to their respective teams.
	 * Please see part(c) of the .pdf file included with this submission for a
	 * detailed justification of the efficiency/complexity.
	 */
	public void addStudentToTeam(Student[] students) {
		
		for (Student student : students) {

			String stdTeamName = student.getTeamName();

			// If team name is already a key, add the student to it.
			if (getTeams().containsKey(stdTeamName)) {

				// Adds the Student to the appropriate Team instance.
				getTeams().get(stdTeamName).addStudentToTeam(student);

			  // The key (team name) is not already in the Map.
			} else {
				
				/* A new Team instance is created with the appropriate Team
				 * name. Then the Student is added, and the Team name and Team
				 * instance is mapped to the data structure.
				 */ 
				Team teamToBeAdded = new Team(stdTeamName);
				
				teamToBeAdded.addStudentToTeam(student);
				getTeams().put(stdTeamName, teamToBeAdded);
			}
		}
	}
	
	// Deletes a single Student from the Team
	public void deleteStudentFromTeam(Student student) {
		
		getTeams().get(student.getTeamName()).deleteStudentFromTeam(student);
		
	}
	
	// A method that prints the team name and its corresponding members.
	public void print() {
		
		getTeams().forEach((teamName, Team) -> System.out.print(Team));
		
	}
	
	// Main for testing.
	public static void main(String[] args) {
		
		Student studentOne = new Student(2088, "Charles", "Alan", "Alpha");
		Student studentTwo = new Student(2099, "Charles", "Abbie", "Alpha");
		Student studentThree = new Student(20099, "Smith", "John", "Bravo");
		Student studentFour = new Student(2011, "Abs", "Jon", "Delta");
		
		Student[] students = {studentOne, studentTwo, studentThree,
							  studentFour};
		
		Teams allTeams = new Teams(students);
		//allTeams.print();
		
		allTeams.addStudentToTeam(new Student(1022, "Almond", "Sue", "Alpha"));
		
		Student[] moreStudents = {new Student(10233, "Brown", "Drew", "Charlie")
								,new Student(99811, "Brown", "Ben", "Charlie")};
		
		allTeams.addStudentToTeam(moreStudents);
		allTeams.print();
		
		allTeams.deleteStudentFromTeam(studentOne);
		System.out.println("\n\n****After deletion****\n\n");
		allTeams.print();
		
	}

}
