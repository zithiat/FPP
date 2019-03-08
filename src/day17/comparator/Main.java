package day17.comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Employee e1 = new Employee("BBB", 5, "999");
		Employee e2 = new Employee("AAA", 1, "777");
		Employee e3 = new Employee("CCC", 3, "111");

		list.add(e1);
		list.add(e2);
		list.add(e3);

		System.out.println("Before sort: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}

		Collections.sort(list, Employee.NAME);

		System.out.println("After sort by Name: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}

		Collections.sort(list, Employee.AGE);

		System.out.println("After sort by Age: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}

		Collections.sort(list, Employee.SSN);
		System.out.println("After sort by SSN: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}
	}

}

/*
 * The ouput looks like the following with some minor changes to the text Every
 * time it compares 2 items the comparator method is called!! JL 07-2011
 * 
 * Before sort: BBB AAA CCC Name comparator is Employee$1 class Employee$1 Name
 * comparator is Employee$1 class Employee$1 After sort by Name: AAA BBB CCC Age
 * Comparator is class Employee$2 Age Comparator is __ Employee$2 Age Comparator
 * is class Employee$2 Age Comparator is __ Employee$2 Age Comparator is class
 * Employee$2 Age Comparator is __ Employee$2 After sort by Age: AAA CCC BBB
 * 
 */