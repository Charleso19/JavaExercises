import java.util.ArrayList;
import java.util.TreeSet;

public class Team {
	
	/* A TreeSet is used to store the Students in the Team in alphabetical
	 * order, as well as safe guarding against duplicate Student instances.
	 * An ArrayList was considered due to it's constant time retrieval rate;
	 * however, due to the requirement of constantly updating the Teams
	 * (assumed to be at this stage as removing and adding Students), 
	 * the ArrayList would have to be constantly resorted, which may effect the
	 * efficiency of the program. Therefore, a TreeSet with it's guaranteed
	 * natural ordering, illegal duplicate values, and guaranteed O(log n)
	 * complexity is the appropriate choice. 
	 */
	private String 			   teamName   ;
	private TreeSet<Student>   teamMembers;
	
	public Team(String teamName) {
		
		this.teamName    = teamName;
		     teamMembers = new TreeSet<>();
		
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public TreeSet<Student> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(TreeSet<Student> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public void addStudentToTeam(Student student) {
		
		getTeamMembers().add(student);
		
	}
	
	public void deleteStudentFromTeam(Student student) {
		
		getTeamMembers().remove(student);
		
	}
	@Override
	public String toString() {
		
		return String.format("%s : %s%n", getTeamName(), getTeamMembers());
	}

}
