import java.util.ArrayList;

public class Offering extends Course {
	private int year;
	private int semester;
	private ArrayList<Session> sessions;
	private ArrayList<Student> students;
	
	/**
	 * Creates a new course offering for the given year and semester
	 * @param courseCode
	 * @param availability
	 * @param prereqs
	 * @param year
	 * @param semester
	 */
	public Offering(String courseCode, int availability, ArrayList<Course> prereqs, int year, int semester) {
		super(courseCode, availability, prereqs);
		this.year = year;
		this.semester = semester;
		this.sessions = new ArrayList<Session>();
		this.students = new ArrayList<Student>();
	}
	
	/**
	 * Enrols a student into this course offering and several sessions in the course
	 * @param s
	 * @param sessions
	 * @precondition the student must have met the prerequisites for the course
	 */
	public void enrol(Student s, ArrayList<Session> sessions) {
		this.students.add(s);
	}
	
	/**
	 * Un-enrols a student from this course offering
	 * @param s
	 */
	public void unenrol(Student s) {
		for(Student t : this.students) {
			if (s.equals(t)) {
				this.students.remove(t);
				break;
			}
		}
	}
	
	/**
	 * Adds a new session to the course offering
	 * @param type
	 * @param location
	 * @param day
	 * @param time
	 * @param capacity
	 */
	public void addSession(String type, String location, String day, int time, int capacity) {
		Session s = new Session(type, location, day, time, capacity);
		this.sessions.add(s);
	}
	
	public int getYear() {
		return year;
	}

	public int getSemester() {
		return semester;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	/**
	 * Checks if an offering is the same as this offering
	 * @param o
	 * @return true if the offerings are the same, otherwise returns false
	 */
	public boolean equals(Offering o) {
		if (this == o) return true;
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false;
		Offering that = (Offering)o;
		if (this.year == that.year && this.semester == that.semester &&
			this.sessions.equals(that.sessions) &&
			this.students.equals(that.students) &&
			this.getCourseCode().equals(that.getCourseCode()) &&
			this.getPrereqs().equals(that.getPrereqs()) &&
			this.getAvailability() == that.getAvailability()) {
			return true;
		}	
		return false;
	}
}
