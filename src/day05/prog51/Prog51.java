package day05.prog51;

import java.util.Scanner;

public class Prog51 {
	// Department employees
	private DeptEmployee[] department;
	
	// Professors
	private Professor p1;
	private Professor p2;
	private Professor p3;
	
	// Secretaries
	private Secretary s1;
	private Secretary s2;
	
	// Administrators
	private Administrator a1;
	private Administrator a2;

	public static void main(String[] args) {
		Prog51 p = new Prog51();
		p.MainClass();
	}
	
	public void MainClass() {
		double sumOfSalaries = 0;
		this.p1 = new Professor("Prof-1", 50000, 1997, 5, 20, 10);
		this.p2 = new Professor("Prof-2", 55000, 1996, 8, 10, 10);
		this.p3 = new Professor("Prof-3", 45000, 1998, 4, 23, 10);
		
		this.s1 = new Secretary("Secr-1", 25000, 1998, 3, 12, 200);
		this.s2 = new Secretary("Secr-2", 27500, 1999, 10, 17, 500);
		
		this.a1 = new Administrator("Admin-1", 0, 2000, 2, 12, 120);
		this.a2 = new Administrator("Admin-2", 0, 2001, 10, 18, 80);
		
		this.department = new DeptEmployee [7];
		this.department[0] = this.p1;
		this.department[1] = this.p2;
		this.department[2] = this.p3;
		this.department[3] = this.s1;
		this.department[4] = this.s2;
		this.department[5] = this.a1;
		this.department[6] = this.a2;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to print the sum of all salaries? Y/N");
		String answer = sc.nextLine();
		if (!answer.equals(null) && "y".equalsIgnoreCase(answer)) {
			for (DeptEmployee de : department) {
				sumOfSalaries += de.computeSalary();
			}
			System.out.println("The summary of all salaries = " + sumOfSalaries);
		} else {
			System.exit(1);
		}
		
		System.out.println("Do you want to search any employee in the department? Y/N");
		answer = sc.nextLine();
		if (!answer.equals(null) && "y".equalsIgnoreCase(answer)) {
			System.out.println("Enter the name to search:");
			String nameToSearch = sc.nextLine();
			boolean foundFlag = false;
			if (!nameToSearch.equals(null) && !"".equals(nameToSearch)) {
				for (DeptEmployee de : department) {
					if (nameToSearch.equals(de.getName())) {
						System.out.println("Found! " + de.toString());
						foundFlag = true;
						break;
					}
				}
				if (!foundFlag) {
					System.out.println("Not found from the given name!");
				}
			}
		} else {
			System.exit(1);
		}
		sc.close();
	}
}
