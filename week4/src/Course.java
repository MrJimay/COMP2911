import java.util.ArrayList;

public class Course {
	private String courseCode;
	// 0 for not available, 1 for semester 1 only, 2 for semester 2 only and 3 for both semesters
	private int availability; 
	private ArrayList<Course> prereqs;
	
	/**
	 * Creates a new course with the specified availability and pre requisites
	 * @param courseCode
	 * @param availability
	 * @param prereqs
	 */
	public Course(String courseCode, int availability, ArrayList<Course>prereqs) {
		this.courseCode = courseCode;
		this.availability = availability;
		this.prereqs = prereqs;
	}
	
	/**
	 * Returns the availability of the course
	 * @return
	 * 0 for not available<br>
	 * 1 for available semester 1 only<br>
	 * 2 for available semester 2 only<br>
	 * 3 for available for both semesters
	 */
	public int getAvailability() {
		return this.availability;
	}
	
	/**
	 * Gets the course code for this course
	 * @return
	 */
	public String getCourseCode() {
		return this.courseCode;
	}
	
	/**
	 * Gets the pre-requisite courses for this course
	 * @return an ArrayList of Courses that are prerequisites for this course
	 */
	public ArrayList<Course> getPrereqs() {
		return this.prereqs;
	}
	
	/**
	 * Checks if a course is the same as this course
	 * @param c
	 * @return true if the courses are the same, otherwise returns false
	 */
	public boolean equals(Course c) {
		if (this == c) return true;
		if (c == null) return false;
		if (c.getClass() != this.getClass()) return false;
		Course that = (Course)c;
		if (this.getCourseCode().equals(that.getCourseCode()) &&
			this.getPrereqs().equals(that.getPrereqs()) &&
			this.getAvailability() == that.getAvailability()) {
			return true;
		}	
		return false;
	}
}
