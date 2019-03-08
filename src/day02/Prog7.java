package day02;

import java.util.*;

public class Prog7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		System.out.print("table name = ");
		String tableName = sc.nextLine();
		System.out.print("number of column names = ");
		int colNum = Integer.parseInt(sc.nextLine());
		String[] colArr = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			System.out.print("column name = ");
			colArr[i] = sc.nextLine();
			sb.append(colArr[i]);
			sb.append((i == colNum - 1) ? "\n" : ",");
		}
		System.out.print("salary value = ");
		int salary = Integer.parseInt(sc.nextLine());
		System.out.println("SQL query:");
		sb.append("FROM " + tableName + "\nWHERE salary > " + (double) salary);
		System.out.println(sb);
		sc.close();
	}
}
