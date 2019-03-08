package day02;

import java.util.*;

public class Prog5 {

	public static void main(String[] args) {
		int count = 0;
		boolean toCheck = true;
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		System.out.println("Enter the character to count:");
		String charToCount = sc.nextLine();
		char[] charArr = charToCount.toCharArray();
		if (charArr.length > 1) {
			System.out.println("Not a character");
			toCheck = false;
		}
		System.out.println("String entered:" + inputStr);
		System.out.print("Reverse the string:");
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			System.out.print(inputStr.charAt(i));
			if (inputStr.charAt(i) == charArr[0]) {
				count++;
			}
		}
		System.out.println();
		if (toCheck) {
			System.out.println("The number of " + charArr[0] + " character:" + count);
		}
		sc.close();
	}
}
