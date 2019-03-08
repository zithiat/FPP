package day07;
import java.util.*;

public class Exponential {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number:");
		double x = Double.parseDouble(sc.nextLine());
		System.out.print("Enter the power number:");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("The exponential of " + x + " powered by " + n + " is " + expo(x, n));
		sc.close();
	}
	
	static double expo(double x, int n) {
		if (n == 0) 
			return 1;
		if (n == 1)
			return x;
		return x * expo(x, n -1);
	}
}
