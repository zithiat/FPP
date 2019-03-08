package day04.prog42;

public class Account {
	private double balance;
	private AccountTypes acctType;
	private Employee employee;
	
	public Account(Employee emp, AccountTypes acctType, double balance) {
		this.employee = emp;
		this.acctType = acctType; 
		this.balance = balance;
	}
	public Account(AccountTypes acctType, double balance) {
		this.acctType = acctType;
		this.balance = balance;
	}
		
	public double getBalance() {
		return balance;
	}

	public AccountTypes getAcctType() {
		return acctType;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Account type:\t" + this.getAcctType() + "\n");
		sb.append("Current bal:\t" + this.getBalance() + "\n");
		return sb.toString();
	}

	public void makeDeposit(double deposit) {
		this.balance += deposit;
	}

	public boolean makeWithdrawal(double amount) {
		if (amount > balance) {
			return false;
		} else  {
			balance -= amount;
		}
		return true;
	}
}
