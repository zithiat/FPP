package day03;

import java.util.*;

public class PalindromeLevel2 {

	public static void main(String[] args) {
		// own test method
		testPalindrome();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word:");
		StringBuffer sb = new StringBuffer(sc.nextLine());
		boolean check = checkPalindrome(sb);
		if (!check) {
			System.out.println("Input string is not palindrome!");
		} else {
			System.out.println("Input string is palindrome!");
		}
		sc.close();
	}
	
	private static boolean checkPalindrome(StringBuffer sb) {
		int inputLen = sb.length();
		if (sb.length() == 0 || sb == null) {
			return false;
		}
		
		// remove space, punctuation marks
		for (int i = 0; i < inputLen; i++) {
			if (Character.isWhitespace(sb.charAt(i)) || !Character.isLetter(sb.charAt(i))) {
				sb.deleteCharAt(i);
				// after delete the character, we need to:
				// - reduce the size of the StringBuffer
				// - move i backward 1 step
				inputLen--;
				i--;
			}
		}
		// debugging purpose only
		// System.out.println("After removing space and punctuation marks:" + sb);
		
		// get the new length after removing space and punctuation marks
		inputLen = sb.length();
		for (int i = 0; i < inputLen / 2; i++) {
			// To convert all chars to be lower case for comparison
			char iChar = Character.toLowerCase(sb.charAt(i));
			char jChar = Character.toLowerCase(sb.charAt(inputLen - 1 - i));
			if (iChar != jChar) {
				return false;
			}
		}
		return true;
	}
	
	private static void testPalindrome() {
		// Some palindrome sentences from http://www.palindromelist.net/
		// A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!
		// Are we not pure? “No sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era.
		String s1 = "A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!";
		String s2 = "Are we not pure? \"No sir!\" Panama’s moody Noriega brags. \"It is garbage!\" Irony dooms a man; a prisoner up to new era.";
		// The original: Are Mac ‘n’ Oliver ever evil on camera?
		// "ABC" is added, s3 is not palindrome
		String s3 = "Are Mac ‘n’ Oliver ABC ever evil on camera?";
		
		if (checkPalindrome(new StringBuffer(s1))) {
			System.out.println("Test: s1 - working");
		} else {
			System.out.println("Test: Recheck the source code");
		}
		
		if (checkPalindrome(new StringBuffer(s2))) {
			System.out.println("Test: s2 - working");
		} else {
			System.out.println("Test: Recheck the source code");
		}
		
		if (!checkPalindrome(new StringBuffer(s3))) {
			System.out.println("Test: s3 - working");
		} else {
			System.out.println("Test: Recheck the source code");
		}
	}
}
