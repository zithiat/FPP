package day05.prog51;

import java.util.Date;
import java.util.GregorianCalendar;

public class DeptEmployee {

	private String name;
	private double salary;
	private Date hireDate;
	
	public DeptEmployee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, day);
		hireDate = cal.getTime();
	}
	
	public double computeSalary() {
		return this.salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return (Date)hireDate.clone();
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}	
}
