package day07;

public class Fib {
	public static void main(String[] args) {
		Fib f = new Fib();
		f.fib(6);
	}

	int fib(int n) {
		System.out.println("Entering fib with n = " + n);
		if (n == 0 || n == 1) {
			return n;
		}

		int retVal = fib(n - 1) + fib(n - 2);
		System.out.println("Returning val " + retVal + " of fib(" + n + ")");
		return retVal;
	}
}
