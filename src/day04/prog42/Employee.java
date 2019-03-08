package day04.prog42;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private Account savingAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private Date hireDay;
	
	public Employee(String name, int year, int month, int day) {
		this.name = name;
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		cal.setLenient(false);
		hireDay = cal.getTime();
	}
	
	public void createNewChecking(double startAmount) {
		this.checkingAcct = new Account(AccountTypes.CHECKING, startAmount);
	}
	
	public void createNewSavings(double startAmount) {
		this.savingAcct = new Account(AccountTypes.SAVINGS, startAmount);
	}
	
	public void createNewRetirement(double startAmount) {
		this.retirementAcct = new Account(AccountTypes.RETIREMENT, startAmount);
	}
	
	public void deposit(AccountTypes acctType, double amt){
		switch (acctType) {
		case CHECKING:
			this.checkingAcct.makeDeposit(amt);
			break;
		case SAVINGS:
			this.savingAcct.makeDeposit(amt);
			break;
		case RETIREMENT:
			this.retirementAcct.makeDeposit(amt);
			break;
		default: break;
		}
	}
	
	public boolean withdraw(AccountTypes acctType, double amt){
		switch (acctType) {
		case CHECKING:
			return this.checkingAcct.makeWithdrawal(amt);
		case SAVINGS:
			return this.savingAcct.makeWithdrawal(amt);
		case RETIREMENT:
			return this.retirementAcct.makeWithdrawal(amt);
		default: break;
		}
		return true;
	}
	
	public String getFormattedAcctInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nACCOUNT INFO FOR " + this.getName() + "\n\n");
		if (this.savingAcct != null) {
			sb.append(this.savingAcct.toString());
		}
		
		if (this.checkingAcct != null) {
			sb.append(this.checkingAcct.toString());
		}
		
		if (this.retirementAcct != null) {
			sb.append(this.retirementAcct.toString());
		}
		
		return sb.toString();		
	}

	public Account getSavingAcct() {
		return savingAcct;
	}

	public Account getCheckingAcct() {
		return checkingAcct;
	}

	public Account getRetirementAcct() {
		return retirementAcct;
	}

	public String getName() {
		return name;
	}

	public Date getHireDay() {
		return hireDay;
	}
}
