package day17;

import java.util.Comparator;

import day17.comparator.Employee;


//An Easier way to write a Comparator!


public class SsnComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		Employee e1=(Employee) o1;
		Employee e2 =(Employee) o2;
		return e1.getSsn().compareTo(e2.getSsn());
	}
}
