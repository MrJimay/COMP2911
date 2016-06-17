
public class Employee {
	private String name;
	private int salary;
	
	/**
	 * Creates a new employee
	 * @param name
	 * @param salary
	 */
	public Employee (String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * Gets the name of the employee
	 * @return Name of employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the salary of the employee
	 * @return Salary of employee
	 */
	public int getSalary() {
		return salary;
	}
	
	/**
	 * Sets the name of the employee
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the salary of the employee
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	/**
	 * Example: Employee JimmyClone = Jimmy.clone() creates a new Employee called JimmyClone
	 * with the same field values as Jimmy.
	 * @return An Employee with the same name and salary
	 */
	public Employee clone() {
		Employee employee = new Employee(this.name, this.salary);
		return employee;	
	}
	
	/**
	 * Checks whether an Employee has the same fields as this instance of the object.
	 * @param e
	 * @return
	 */
	public boolean equals(Object e) {
		if (e == null) return false;
		if (this == e) return true;
		if (this.getClass() != e.getClass()) return false;
		Employee that = (Employee)e;
		if (this.getName() == that.getName() && this.getSalary() == that.getSalary()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a string representation of an Employee object
	 */
	public String toString() {
		return this.getClass().getName() + '@' + Integer.toHexString(hashCode());
	}
}
