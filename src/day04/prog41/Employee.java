package day04.prog41;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private double salary;
	private GregorianCalendar hireDay;
	
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		this.hireDay = new GregorianCalendar();
		hireDay.setLenient(false);
		hireDay.set(Calendar.YEAR, year);
		hireDay.set(Calendar.MONTH, month);
		hireDay.set(Calendar.DATE, day);
		hireDay.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public GregorianCalendar getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public double yearlyFederalTax() {
		return (this.salary > 80000) ? this.salary * 28 / 100 : (
				(this.salary > 50000) ? this.salary * 24 / 100 : (
						(this.salary > 26000) ? this.salary * 20 / 100 : 0)); 
	}
}
