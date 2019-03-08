package day04.prog42;

import java.util.Scanner;

public class Prog42 {

	private static Employee[] emps = null;
	
	public static void main(String[] args) {
		Main();
	}
	
	private static void Main() {
		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);

		Scanner sc = new Scanner(System.in);
		System.out.print("See a report of all account balances? (y/n) ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("y")){
			String info = getFormattedAccountInfo();
			//display info to console
			System.out.println(info);
			sc.close();
		}
		else {
			sc.close();
			System.exit(1);
		}
	}
	
	private static String getFormattedAccountInfo() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < emps.length; i++) {
			sb.append(emps[i].getFormattedAcctInfo());
		}
		return sb.toString();		
	}
}
