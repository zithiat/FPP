package prob1dec17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeAdmin {
	
	/**
		Returns a list of Employees whose social security number is on the input list socSecNums
		and whose salary is > 80000. The list must be ordered by social security number,
		from lowest to highest. To sort, you must use a Collections sorting method
		and you must define your own Comparator to be used to compare Employees by ssn. 
	*/
	public static List<Employee> prepareReport(HashMap<String, Employee> table, List<String> socSecNums) {
		ArrayList<Employee> tmpList = new ArrayList<Employee>();
		for (Map.Entry<String, Employee> e : table.entrySet()) {
			if (socSecNums.contains(e.getKey()) && e.getValue().getSalary() > 80000) {
				tmpList.add(e.getValue());
			}
		}
		Collections.sort(tmpList, SSN);
		return tmpList;
	}
	
	public static final Comparator<Employee> SSN = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getSsn().compareTo(e2.getSsn());
		}
	};
}
