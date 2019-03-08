package day04.prog41;

public class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountTypes acctType;
	private Employee employee;
	
	public Account(Employee emp, AccountTypes acctType, double balance) {
		this.employee = emp;
		this.acctType = acctType; 
		this.balance = balance;
	}

	public Account(Employee emp, String acctType) {
		// Default account is CHECKING
		// It can be changed via changeAccountType() method
		this(emp, AccountTypes.CHECKING, DEFAULT_BALANCE);
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
		return "type = " + acctType + ", balance = " + balance + ", interest computed = " + computeInterest();
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
	
	public double computeInterest() {
		return this.balance * (acctType.equals(AccountTypes.CHECKING) ? 0.02 : (
				(acctType.equals(AccountTypes.SAVINGS) ? 0.04 : (
						(acctType.equals(AccountTypes.RETIREMENT) ? 0.05 : 0 ) ) ) ) ) ;
	}
	
	public void changeAccountType(AccountTypes newAccType) {
		this.acctType = newAccType;
	}
}
