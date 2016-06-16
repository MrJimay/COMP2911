
public class InternetAccount extends BankAccount {
	private int internetPayments;
	
	/**
	 * Creates a new internet account
	 * @param name
	 * @param balance
	 */
	public InternetAccount(String name) {
		super(name);
		this.internetPayments = 0;
	}
	
	/**
	 * Makes an internet payment
	 * @param amount
	 * @precondition balance >= 0
	 * @postcondition balance >= 0
	 */
	public void internetPayment(float amount) {
		if (this.internetPayments < 10) {
			if (withdraw(amount)) {
				this.internetPayments++;
			}		
		} else {
			System.out.println("You have already made 10 internet payments this month. Please wait until next month.");
		}
	}
	
	/**
	 * Gets the number of internet payments made that month
	 * @return the number of internet payments made that month
	 */
	public int getPayments() {
		return this.internetPayments;
	}
	
	/**
	 * Resets internet payments to 0
	 */
	public void resetPayments() {
		this.internetPayments = 0;
	}
	
	/**
	 * Prints out the amount withdrawn, number of internet payments and balance of an account
	 */
	public void printDetails() {
		System.out.println("Balance: $" + this.getBalance() + "\nAmount Withdrawn: $" + this.amountWithdrawn() + "\nNum Internet Payments: " + this.getPayments());
	}
}
