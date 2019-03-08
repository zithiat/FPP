package sep03prob2.solution;

import java.util.List;

public class AccountManager {
	public static double computeAccountBalanceSum(List<Employee> emps) {
		double total = 0;
		if (emps == null) 
			return 0.0;
		for (Employee e : emps) {
			if (e != null) {
				for (Account a : e.getAccounts()) {
					if (a != null) {
						total += a.getBalance();
					}
				}
			}
		}
		return total;
	}
}
