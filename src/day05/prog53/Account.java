package day05.prog53;

public class Account {
	private double balance;
	private String acctType;
	private Employee employee;
	
	public Account(Employee emp, double balance) {
		this.employee = emp;
		this.balance = balance;
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
		
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double amount) {
		this.balance = amount;
	}
	
	public String getAcctType() {
		return this.acctType;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void makeDeposit(double deposit) {
		this.balance += deposit;
	}

	public boolean makeWithdrawal(double amount) {
		if (amount > balance) {
			System.out.println("Given amount is more than the current balance.");
			return false;
		} else  {
			balance -= amount;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Account type:\t" + this.getAcctType() + "\n");
		sb.append("Current bal:\t" + String.format("$%,.1f", this.getBalance()) + "\n");
		return sb.toString();
	}

}
