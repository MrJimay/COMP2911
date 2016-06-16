
public class BankAccount {
	private String name;
	private float balance;
	private float amountWithdrawn;
	private static float MAX_WITHDRAWAL = 800;
	
	/**
	 * Creates a new bank account with $0 balance
	 * @param name
	 */
	public BankAccount(String name) {
		this.name = name;
		this.balance = 0;
		this.amountWithdrawn = 0;
	}
	
	/**
	 * Withdraws the specified amount from the bank account balance
	 * Returns a boolean indicating whether the withdrawal was successful
	 * @param amount
	 * @precondition balance >= 0
	 * @postcondition balance >= 0
	 * @return
	 */
	public boolean withdraw(float amount) {
		boolean result = false;
		if (this.balance >= amount) {
			if (this.amountWithdrawn + amount <= MAX_WITHDRAWAL) {
				this.balance -= amount;
				this.amountWithdrawn += amount;
				result = true;
			} else {
				System.out.println("You have reached your daily withdrawal limit.");
			}
		} else {
			System.out.println("You have do not have enough funds.");
		}
		return result;
	}
	
	/**
	 * Deposits the specified amount into the bank account balance
	 * @param amount
	 * @precondition balance >= 0
	 * @postcondition balance >= 0
	 */
	public void deposit(float amount) {
		this.balance += amount;
	}
	
	/**
	 * Lets the user check the balance of their bank account
	 * @return
	 */
	public float getBalance() {
		return this.balance;
	}
	
	/**
	 * Lets the user check the amount they have withdrawn for that day
	 * @return
	 */
	public float amountWithdrawn() {
		return this.amountWithdrawn;
	}
	
	/**
	 * Resets amount withdrawn to 0
	 */
	public void resetAmountWithdrawn() {
		this.amountWithdrawn = 0;
	}
	
	/**
	 * Prints out the amount withdrawn and balance of an account
	 */
	public void printDetails() {
		System.out.println("Balance: $" + this.getBalance() + "\nAmount Withdrawn: $" + this.amountWithdrawn());
	}
}
