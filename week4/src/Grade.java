
public class Grade {
	private String grade;
	private int mark;
	private Offering offering;
	
	public Grade(String grade, int mark, Offering o) {
		this.grade = grade;
		this.mark = mark;
		this.offering = o;
	}
	
	public String getGrade() {
		return grade;
	}
	public int getMark() {
		return mark;
	}
	public Offering getOffering() {
		return offering;
	}
}
