package day03;

import java.util.*;

public class StringBufferLab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out.println("Enter a string:");
		sb.append(sc.nextLine());
		sb.append("bye");
		System.out.println("After append 'bye':" + sb);
		if (sb.length() == 0) {
			System.out.println("Empty string");
		}
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sb.setCharAt(i, Character.toUpperCase(c));
			} else if (c >= 'A' && c <= 'Z') {
				sb.setCharAt(i, Character.toLowerCase(c));
			}
		}
		System.out.println("After converting:" + sb);
		sc.close();
	}
}
