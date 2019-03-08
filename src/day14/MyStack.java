package day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MyStack {
	private static LinkedList<Integer> myStack = new LinkedList<Integer>();

	public static void main(String[] args) {
		System.out.println("Lab 1");
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> intList = new LinkedList<Integer>();
		int n;
		while (true) {
			n = Integer.parseInt(sc.nextLine());
			if (n == -1) {
				break;
			} else {
				intList.add(n);
			}
		}
		stacklab1ab(intList);

		System.out.println("==============================");
		System.out.println("Lab 2a");
		String lab2Str1 = "(a + b[(x + y)] + 10)";
		stacklab2a(lab2Str1);
		String lab2Str2 = "(a + b[(x + y)] + (c))";
		stacklab2a(lab2Str2);
		String lab2Str3 = "(a + b[(x + y)] + (c) + [(a * d) + (c + 10)])";
		stacklab2a(lab2Str3);
		String lab2Str4 = "(a + b[(x + y)] + (c) + [(a * d) + (c + 10])";
		stacklab2a(lab2Str4);
		String lab2Str5 = "(a + b[(x + y)] + (c) + [a * d) + (c + 10])";
		stacklab2a(lab2Str5);

		System.out.println("==============================");
		System.out.println("Lab 2b");
		String s = sc.nextLine();
		stacklab2b(s);

		System.out.println("==============================");
		System.out.println("Lab 2c, to quit the input, hit QUIT");
		ArrayList<String> arrStr = new ArrayList<String>();
		while (true) {
			String s1 = sc.nextLine();
			if ("QUIT".equals(s1)) {
				break;
			} else {
				arrStr.add(s1);
			}
		}
		stacklab2c(arrStr);

		sc.close();
	}

	public static void stacklab1ab(LinkedList<Integer> listInt) {
		if (listInt != null) {
			System.out.println("Input:" + listInt.toString());
			Iterator<Integer> it = listInt.iterator();
			while (it.hasNext()) {
				Integer n = (Integer) it.next();
				myStack.push(n);
			}
		}
		System.out.print("The integers reversed are : ");
		int count = 0;
		int size = myStack.size();
		while (!myStack.isEmpty()) {
			Integer n = myStack.pop();
			count++;
			System.out.print(((count == size) ? "and " + n : n + ", "));
		}
		System.out.println();
	}

	public static void stacklab2a(String s) {
		LinkedList<Character> delimiterStack = new LinkedList<Character>();
		System.out.println(s);
		boolean flag = true;
		String delimeter = "()[]{}";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (delimeter.contains(c + "")) {
				if (c == '(' || c == '[' || c == '{') {
					delimiterStack.push(c);
				} else {
					if (!delimiterStack.isEmpty()) {
						char inStack = delimiterStack.pop();
						if ((c == '}' && inStack != '{') || (c == ']' && inStack != '[')
								|| (c == ')' && inStack != '(')) {
							flag = false;
						}
					} else {
						flag = false;
					}
				}
			}
		}
		if (!flag) {
			System.out.println("All delimiters NOT matched!");
		} else {
			System.out.println("All delimiters matched!");
		}
	}

	public static void stacklab2b(String s) {
		LinkedList<Character> delimiterStack = new LinkedList<Character>();
		if (s.equals(null) || s.equals("")) {
			System.out.println("No delimiter");
		}
		boolean flag = false;
		int pos = -1;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '/') {
				if (delimiterStack.isEmpty()) {
					delimiterStack.push(c);
					pos = i;
				} else {
					char cc = delimiterStack.pop();
					if (c == cc && pos == i - 1) {
						flag = true;
						break;
					}
				}
			} else if (c == '"') {
				delimiterStack.push(c);
				count++;
				if (count == 2) {
					if (!delimiterStack.isEmpty()) {
						char cc = delimiterStack.pop();
						if (c == cc) {
							flag = true;
							break;
						}
					}
				}
			}
		}
		if (flag) {
			System.out.println("Comment delimiters matched!");
		} else {
			System.out.println("Comment delimiters NOT matched!");
		}
	}

	public static void stacklab2c(ArrayList<String> ss) {
		LinkedList<Character> delimiterStack = new LinkedList<Character>();
		if (ss.equals(null) || ss.size() == 0) {
			System.out.println("No delimiter");
		}
		boolean flag = false;
		String del = "/*";
		int count = 0;
		for (String s : ss) {
			if (s.equals(null) || s.equals("")) {
				flag = false;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!del.contains(c + "")) {
					flag = false;
					break;
				} else {
					if ((c == '/' && s.charAt(i + 1) == '*' && i < s.length() - 2)
							|| (c == '*' && s.charAt(i - 1) == '/')) {
						if (count < 2) {
							delimiterStack.push(c);
							count++;
						} else if (count == 2) {
							if (!delimiterStack.isEmpty()) {
								char cc = delimiterStack.peekFirst();
								if (c == cc) {
									flag = true;
									count--;
									if (count == 0) {
										break;
									}
								}
							}
						}
					}
				}
			}
			if (flag) {
				break;
			}
		}
		if (flag) {
			System.out.println("Comment delimiters matched!");
		} else {
			System.out.println("Comment delimiters NOT matched!");
		}
	}
}
