import java.util.ArrayList;

public class Student {
	private String name;
	private int ID;
	private ArrayList<Offering> currentOfferings;
	private ArrayList<Session> currentSessions;
	private ArrayList<Grade> grades;
	
	/**
	 * Creates a new student
	 * @param name
	 * @param ID
	 */
	public Student(String name, int ID) {
		this.name = name;
		this.ID = ID;
		this.currentOfferings = new ArrayList<Offering>();
		this.currentSessions = new ArrayList<Session>();
		this.grades = new ArrayList<Grade>();
	}
	
	/**
	 * Sets the name of the student
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Adds a course offering
	 * @param o
	 */
	public void addOffering(Offering o) {
		currentOfferings.add(o);
	}
	
	/**
	 * Removes an offering
	 * @param o
	 */
	public void removeOffering(Offering o) {
		for (Offering p : this.currentOfferings) {
			if (o.equals(p)) {
				this.currentOfferings.remove(p);
				break;
			}
		}
	}
	
	/**
	 * Adds a sessions
	 * @param s
	 */
	public void addSessions(Session s) {
		currentSessions.add(s);
	}
	
	/**
	 * Removes a session
	 * @param s
	 */
	public void removeSession(Session s) {
		for (Session t : this.currentSessions) {
			if (s.equals(t)) {
				this.currentSessions.remove(t);
				break;
			}
		}
	}
	
	/**
	 * 
	 * @return an ArrayList of courses that the student has passed
	 */
	public ArrayList<Course> getPassedCourses() {
		ArrayList<Course> passedCourses = new ArrayList<Course>();
		for (Grade g : grades) {
			if (!g.getGrade().equals("fail")) {
				passedCourses.add(g.getOffering());
			}
		}
		return passedCourses;
	}
	
	/**
	 * Adds a grade
	 * A grade must be one of:
	 * - "pass"
	 * - "fail"
	 * - "hd"
	 * - "d"
	 * - "c"
	 * "
	 * @param o
	 */
	public void addGrade(String grade, int mark, Offering o) {
		if (grade.equals("pass") || grade.equals("fail") || grade.equals("hd") || grade.equals("d") || grade.equals("c")) {
			Grade g = new Grade(grade, mark, o);
			grades.add(g);
		}	
	}
	
	/**
	 * Checks if a student is the same as this student
	 * @param s
	 * @return true if the students are the same, otherwise returns false
	 */
	public boolean equals(Object s) {
		if (this == s) return true;
		if (s == null) return false;
		if (s.getClass() != this.getClass()) return false;
		Student that = (Student)s;
		if (this.name == that.name && this.ID == that.ID &&
			this.currentOfferings.equals(that.currentOfferings) &&
			this.currentSessions.equals(that.currentSessions) &&
			this.grades.equals(that.grades)) {
			return true;
		}	
		return false;
	}
}
