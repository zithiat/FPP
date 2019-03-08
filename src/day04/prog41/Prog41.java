package day04.prog41;

public class Prog41 {

	private static Employee[] myEmps = new Employee[4];
	private static Account[] myAccts = new Account[4];
	
	public static void main(String[] args) {
		System.out.println("Test Employee class");
		testEmployee(); 
		System.out.println("\nTest Account class");
		testAccount();
	}
	
	private static void testEmployee() {		
		myEmps[0] = new Employee("John", 85000, 1999, 3, 10);
		myEmps[1] = new Employee("Harry", 60000, 1999, 7, 20);
		myEmps[2] = new Employee("Kate", 48000, 1999, 10, 25);
		myEmps[3] = new Employee("Jim", 25500, 1998, 5, 12);
		
		for (Employee e : myEmps) {
			System.out.println("Hired day of " + e.getName() + " is " + e.getHireDay().getTime());
			System.out.println("Yearly Federal tax of " + e.getName() + " with salary " + e.getSalary() + " is "
					+ e.yearlyFederalTax());
			System.out.println();
		}
		
		System.out.println("Raise salary for Kate");
		for (Employee e : myEmps) {
			if ("Kate".equals(e.getName())) {
				e.raiseSalary(5);
			}
		}
		
		for (Employee e : myEmps) {
			System.out.println("Hired day of " + e.getName() + " is " + e.getHireDay().getTime());
			System.out.println("Yearly Federal tax of " + e.getName() + " with salary " + e.getSalary() + " is "
					+ e.yearlyFederalTax());
			System.out.println();
		}
	}
	
	private static void testAccount() {
		for (int i = 0; i < myAccts.length; i++) {
			myAccts[i] = new Account(myEmps[i], AccountTypes.values()[i%3], 300);
		}
		
		for (Account a : myAccts) {
			System.out.println(a.toString());
		}
		System.out.println();
		
		for (int i = 0; i < myAccts.length; i++) {
			myAccts[i].makeDeposit(i * 5000);
			System.out.println(myAccts[i].toString());
		}
		System.out.println();
		
		for (int i = 0; i < myAccts.length; i++) {
			double withdrawalAmount = (i + 1) * 500;
			String yesOrNo = (myAccts[i].makeWithdrawal(withdrawalAmount)) ? "Yes" : "No";
			System.out.println("Can " + myAccts[i].getEmployee().getName() + " make a withdrawal of " + withdrawalAmount + "? " + yesOrNo);
		}
	}
}
