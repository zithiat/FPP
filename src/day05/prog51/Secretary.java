package day05.prog51;

public class Secretary extends DeptEmployee {

	private double overtimeHours;
	
	public Secretary(String name, double salary, int year, int month, int day, double overtimeHours) {
		super(name, salary, year, month, day);
		this.overtimeHours = overtimeHours;
	}

	public double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	@Override
	public double computeSalary() {
		return super.computeSalary() + 12 * overtimeHours;
	}

	@Override
	public String toString() {
		return "Secretary [name=" + getName() + ", hireDate=" + getHireDate() + ", salary=" + computeSalary()
				+ ", overtimeHours=" + overtimeHours + "]";
	}
}
