package day05.prog51;

public class Administrator extends DeptEmployee {

	private int numOfWorkHours;
	
	public Administrator(String name, double salary, int year, int month, int day, int numOfWorkHours) {
		super(name, salary, year, month, day);
		this.numOfWorkHours = numOfWorkHours;
	}
	
	@Override
	public double computeSalary() {
		return numOfWorkHours * 20;
	}
	
	@Override
	public String toString() {
		return "Administrator [name=" + getName() + ", hireDate=" + getHireDate()
		+ ", salary=" + computeSalary() + ", numOfWorkHours=" + numOfWorkHours + "]";
	}
}
