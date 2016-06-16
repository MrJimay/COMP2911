import java.util.ArrayList;

public class EnrolmentSystem {
	private ArrayList<Course> courses;
	private ArrayList<Offering> offerings;
	private ArrayList<Student> students;
	private int currentYear;
	private int currentSemester;
	
	public EnrolmentSystem(int year, int semester) {
		this.currentSemester = semester;
		this.currentYear = year;
		this.courses = new ArrayList<Course>();
		this.offerings = new ArrayList<Offering>();
		this.students = new ArrayList<Student>();
	}
	
	public int getCurrentYear() {
		return currentYear;
	}
	
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	
	public int getCurrentSemester() {
		return currentSemester;
	}
	
	public void setCurrentSemester(int currentSemester) {
		this.currentSemester = currentSemester;
	}
	
	/**
	 * Adds a new student to the enrolment system
	 * @param name
	 * @param ID
	 */
	public void addStudent(String name, int ID) {
		Student s = new Student(name, ID);
		students.add(s);
	}
	
	/**
	 * Adds a new course to the enrolment system if there is no course with the same course code
	 * Availability 0 means it is never available
	 * Availability 1 means it is available semester 1 only
	 * Availability 2 means it is available semester 2 only
	 * Availability 3 means it is available both semesters
	 * @param courseCode
	 * @param availability
	 * @param prerequisites
	 * @return true if adding was successful, otherwise returns false
	 */
	public boolean addCourse(String courseCode, int availability, ArrayList<Course> prerequisites) {
		for (Course c : courses) {
			if (c.getCourseCode().equals(courseCode)) {
				return false;
			}
		}
		Course c = new Course(courseCode, availability, prerequisites);
		courses.add(c);
		return true;
	}
	
	/**
	 * Finds a course with the given course code
	 * @param courseCode
	 * @return a course with the given course code if it exists, otherwise returns null
	 */
	public Course findCourseByCode(String courseCode) {
		for (Course c : courses) {
			if (c.getCourseCode().equals(courseCode)) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Finds an offering with the given course code, year and semester
	 * @param courseCode
	 * @param year
	 * @param semester
	 * @return an offering with the given course code, year and semester if it exists, otherwise returns null
	 */
	public Offering findOffering(String courseCode, int year, int semester) {
		for (Offering o : offerings) {
			if (o.getCourseCode().equals(courseCode) && o.getYear() == year && o.getSemester() == semester) {
				return o;
			}
		}
		return null;
	}
	
	/**
	 * Creates new offerings for the current semester
	 */
	public void createOfferingsForCurrentSemester() {
		for (Course c : courses) {
			if (currentSemester == c.getAvailability() || currentSemester == 3) {
				Offering newOffering = new Offering(c.getCourseCode(), c.getAvailability(), c.getPrereqs(), 
						currentYear, currentSemester);
				offerings.add(newOffering);
					
			}
		}
	}
	
	/**
	 * Enrols a student into the course offering and sessions
	 * @param s
	 * @param o
	 * @param sessions
	 * @precondition sessions must be part of the offering
	 * @return true if enrolment was successful, otherwise returns false
	 */
	public boolean enrol(Student s, Offering o, ArrayList<Session> sessions) {
		if (!prerequisitesSatisfied(s, o)) return false;
		s.addOffering(o);
		o.enrol(s, sessions);
		for (Session session : sessions) {
			s.addSessions(session);
			session.enrol(s);
		}
		return true;
	}
	
	/**
	 * 
	 * @param o
	 * @return all the sessions in an offering
	 */
	public ArrayList<Session> getSessions(Offering o) {
		return o.getSessions();
	}
	
	public boolean prerequisitesSatisfied(Student s, Offering o) {
		boolean passed = false;
		// this code could be much simpler if Course implemented .contains()
		for (Course prereq : o.getPrereqs()) {
			passed = false;
			for (Course c : s.getPassedCourses()) {
				if (c.equals(prereq)) {
					passed = true;
				}
			}
			if (passed == false) {
				return false;
			}
		}
		return true;
	}
}
