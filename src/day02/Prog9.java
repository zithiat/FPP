package day02;

import java.util.Scanner;

public class Prog9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int inputLen = input.length();
		for (int subLen = 0; subLen <= inputLen; subLen++) {
			if (subLen == 0) {
				System.out.println("substring with length:" + subLen);
				System.out.println("[]");
			} else {
				System.out.println("substring with length:" + subLen);
				for (int i = 0; i <= inputLen - subLen; i++) {
					System.out.println("[" + input.substring(i, i + subLen) + "]");
				}
			}
		}
		sc.close();
	}
}
