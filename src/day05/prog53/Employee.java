package day05.prog53;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private Date hireDay;
	private ArrayList<Account> accounts;
	
	public Employee(String name, int year, int month, int day) {
		this.name = name;
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		cal.setLenient(false);
		hireDay = cal.getTime();
		accounts = new ArrayList<Account>();
	}
	
	public String getFormattedAcctInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nACCOUNT INFO FOR " + this.getName() + "\n\n");
		for (Account a : accounts) {
			sb.append(a.toString());
		}
		return sb.toString();		
	}

	public String getName() {
		return name;
	}

	public Date getHireDay() {
		return hireDay;
	}
	
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}
}
