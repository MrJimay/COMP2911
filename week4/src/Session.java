import java.util.ArrayList;

/*
 * For simplicity Session only caters for 3 types of classes:
 * - Lectures
 * - Labs
 * - Tutorials
 * In a better designed solution, this would be an interface, 
 * and the different types of classes would implement Session.
 */
public class Session {
	private String type;
	private String location;
	private String day;
	private int time;
	private int capacity;
	private ArrayList<Student> students;
	
	/**
	 * Creates a new session
	 * @param type
	 * @param location
	 * @param day
	 * @param time
	 */
	public Session(String type, String location, String day, int time, int capacity) {
		this.type = type;
		this.location = location;
		this.day = day;
		this.time = time;
		this.capacity = capacity;
		this.students = new ArrayList<Student>();
	}

	public String getType() {
		return type;
	}

	public String getLocation() {
		return location;
	}

	public String getDay() {
		return day;
	}

	public int getTime() {
		return time;
	}

	public int getCapacity() {
		return capacity;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
	
	/**
	 * Enrols a student in this session if not full
	 * @param s
	 */
	public void enrol(Student s) {
		if (this.students.size() < this.capacity) {
			this.students.add(s);
		} else {
			System.out.println("This session is full.");
		}
	}
	
	/**
	 * Un-enrols a student from this session
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
	 * Checks if a session is the same as this session
	 * @param s
	 * @return true if the sessions are the same, otherwise returns false
	 */
	public boolean equals(Object s) {
		if (this == s) return true;
		if (s == null) return false;
		if (s.getClass() != this.getClass()) return false;
		Session that = (Session)s;
		if (this.type.equals(that.type) && this.location.equals(that.location) &&
			this.day.equals(that.day) && this.time == that.time &&
			this.students.equals(that.students) &&
			this.capacity == that.capacity) {
			return true;
		}	
		return false;
	}
}
