
public class Manager extends Employee {
	private String HireDate;
	
	/**
	 * Creates a new manager
	 * @param name
	 * @param salary
	 * @param HireDate
	 */
	public Manager(String name, int salary, String HireDate) {
		super(name, salary);
		this.HireDate = HireDate;
		
	}
	
	/**
	 * Sets the HireDate of the manager
	 * @param HireDate
	 */
	public void setHireDate(String HireDate) {
		this.HireDate = HireDate;
	}
	
	/**
	 * Gets the HireDate of the manager
	 * @return HireDate
	 */
	public String getHireDate() {
		return this.HireDate;
	}
	
	/**
	 * Example: Manager JimmyClone = Jimmy.clone() creates a new Manager called JimmyClone
	 * with the same field values as Jimmy.
	 * @return An Manager with the same name, salary and hire date
	 */
	public Manager clone() {
		Manager manager = new Manager(this.getName(), this.getSalary(), this.HireDate);
		return manager;	
	}
	
	/**
	 * Checks whether a Manager has the same fields as this instance of the object.
	 * @param e
	 * @return
	 */
	public boolean equals(Object m) {
		if (m == null) return false;
		if (this == m) return true;
		if (this.getClass() != m.getClass()) return false;
		Manager that = (Manager)m;
		if (this.getName() == that.getName() && this.getSalary() == that.getSalary()) {
			return true;
		} else {
			return false;
		}
	}
}
