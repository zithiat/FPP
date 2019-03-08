package day05.prog51;

public class Professor extends DeptEmployee {

	private int numberOfPublications;

	public Professor(String name, double salary, int year, int month, int day, int numberOfPublications) {
		super(name, salary, year, month, day);
		this.numberOfPublications = numberOfPublications;
	}

	public int getNumberOfPublications() {
		return numberOfPublications;
	}

	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}

	@Override
	public String toString() {
		return "Professor [name=" + getName() + ", hireDate=" + getHireDate()
		+ ", salary=" + computeSalary() + ", numberOfPublications=" + numberOfPublications + "]";
	}
}
