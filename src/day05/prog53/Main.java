package day05.prog53;

import java.util.ArrayList;
import java.util.Scanner;

import day05.prog53.Employee;

public class Main {

	private static ArrayList<Employee> emps = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		createEmployees();
		Main();
	}
	
	public static void Main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("A. See a report of all accounts.\n" + 
							"B. Make a deposit.\n" + 
							"C. Make a withdrawal.\n" + 
							"Make a selection (A/B/C):");
		String str = sc.nextLine();
		int emplIndex = -1;
		int acctIndex = -1;
		double amount = 0;
		switch (str) {
		case "A": // report of all accounts
			System.out.println(getFormattedAccountInfo());
			break;
		case "B": // deposit
			showListEmployees();
			System.out.println("Select an employee:");
			emplIndex = Integer.parseInt(sc.nextLine());
			showListAccount(emplIndex);
			System.out.println("Select an account: (type a number)");
			acctIndex = Integer.parseInt(sc.nextLine());
			System.out.println("Deposit amount: ");
			amount = Double.parseDouble(sc.nextLine());
			makeDeposit(emplIndex, acctIndex, amount);
			break;
		case "C": // withdraw
			showListEmployees();
			System.out.println("Select an employee:");
			emplIndex = Integer.parseInt(sc.nextLine());
			showListAccount(emplIndex);
			System.out.println("Select an account: (type a number)");
			acctIndex = Integer.parseInt(sc.nextLine());
			System.out.println("Withdrawal amount: ");
			amount = Double.parseDouble(sc.nextLine());
			makeWithdrawal(emplIndex, acctIndex, amount);
			break;
		default: 
			System.out.println("Incorrect input, system exits");
			break;
		}
		System.out.println("Total all balances: " + String.format("$%,.1f", forAllEmployeesTotalOfAllBalances()));
		sc.close();
	}
	
	private static void createEmployees() {
		emps.add(new Employee("Jim Daley", 2000, 9, 4));
		emps.add(new Employee("Bob Reuben", 1998, 1, 5));
		emps.add(new Employee("Susan Randolph", 1997, 2,13));
		
		emps.get(0).getAccounts().add(new CheckingAccount(10500));
		emps.get(0).getAccounts().add(new SavingsAccount(1000));
		emps.get(0).getAccounts().add(new RetirementAccount(9300));
		
		emps.get(1).getAccounts().add(new CheckingAccount(34000));
		emps.get(1).getAccounts().add(new SavingsAccount(27000));
		
		emps.get(2).getAccounts().add(new CheckingAccount(10038));
		emps.get(2).getAccounts().add(new SavingsAccount(12600));
		emps.get(2).getAccounts().add(new RetirementAccount(9000));
	}
	
	private static String getFormattedAccountInfo() {
		StringBuffer sb = new StringBuffer();
		for (Employee e : emps) {
			sb.append(e.getFormattedAcctInfo());
		}
		return sb.toString();
	}

	private static void makeDeposit(int emplIndex, int acctIndex, double amount) {
		if (amount <= 0 || emplIndex < 0 || acctIndex < 0) {
			System.out.println("Input value invalid, system exits.");
			System.exit(1);
		}
		Employee tmpEmpl = emps.get(emplIndex);
		Account tmpAcct = tmpEmpl.getAccounts().get(acctIndex);
		// debugging purpose only
		// System.out.println("Before: employee:" + tmpEmpl.getName() + "--account:" + tmpAcct.getBalance());
		
		tmpAcct.setBalance(tmpAcct.getBalance() + amount);
		System.out.println(String.format("$%,.1f", amount) + " has been deposited in the \n" + 
				"savings account of " + tmpEmpl.getName());
	}
	
	private static void makeWithdrawal(int emplIndex, int acctIndex, double amount) {
		if (amount <= 0 || emplIndex < 0 || acctIndex < 0) {
			System.out.println("Input value invalid, system exits.");
			System.exit(1);
		}
		Employee tmpEmpl = emps.get(emplIndex);
		Account tmpAcct = tmpEmpl.getAccounts().get(acctIndex);
		// debugging purpose only
		// System.out.println("Before: employee:" + tmpEmpl.getName() + "--account:" + tmpAcct.getBalance());
		
		tmpAcct.makeWithdrawal(amount);
		System.out.println(String.format("$%,.1f", amount) + " has been deposited in the \n" + 
				"savings account of " + tmpEmpl.getName());
	}
	
	private static double forAllEmployeesTotalOfAllBalances() { //totalOfAllBalances()
		double total = 0;
		for (Employee e : emps) {
			for (Account a : e.getAccounts()) {
				total += a.getBalance();
			}
		}
		return total;
	}

	private static void showListEmployees() {
		for (int i = 0; i < emps.size(); i++) {
			System.out.println(i + ".\t" + emps.get(i).getName());
		}
	}
	
	private static void showListAccount(int index) {
		for (int i = 0; i < emps.get(index).getAccounts().size(); i++) {
			System.out.println(i + ".\t" + emps.get(index).getAccounts().get(i).getAcctType().toLowerCase());
		}
	}
}
