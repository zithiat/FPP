package day03;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word:");
		String input = sc.nextLine();
		int inputLen = input.length();
		boolean palindromeFlag = true;

		for (int i = 0; i < inputLen / 2; i++) {
			// To convert all chars to be lower case for comparison
			char iChar = Character.toLowerCase(input.charAt(i));
			char jChar = Character.toLowerCase(input.charAt(inputLen - 1 - i));
			if (iChar != jChar) {
				palindromeFlag = false;
				break;
			}
		}
		
		if (!palindromeFlag) {
			System.out.println("Input string is not palindrome!");
		} else {
			System.out.println("Input string is palindrome!");
		}
		sc.close();
	}

}
