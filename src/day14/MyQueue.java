package day14;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyQueue {

	private static LinkedList<Integer> myStack = new LinkedList<Integer>();
	private static Queue<Integer> myQueue = new LinkedList<Integer>();

	public static void main(String[] args) {
		System.out.println("Enter integers for stack and queue labs, -1 to exit");
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

		queueLab1(intList);
		lab2();
		sc.close();
	}

	public static void queueLab1(LinkedList<Integer> intList) {
		if (intList != null) {
			System.out.println("Input:" + intList.toString());
			Iterator<Integer> it = intList.iterator();
			while (it.hasNext()) {
				Integer n = (Integer) it.next();
				myStack.push(n);
			}
		}
		System.out.println("myStack:" + myStack);
		System.out.println("a. Move all items from Stack to Queue");
		while (!myStack.isEmpty()) {
			myQueue.add(myStack.pop());
		}
		System.out.println("myQueue:" + myQueue);
		System.out.println("myStack:" + myStack);

		System.out.println("b. Move all items from Queue to Stack");
		while (!myQueue.isEmpty()) {
			myStack.push(myQueue.poll());
		}
		System.out.println("myQueue:" + myQueue);
		System.out.println("myStack:" + myStack);

		System.out.println("c. Empty one stack onto the top of another stack");
		lab1c();
	}

	public static void lab1c() {
		LinkedList<Integer> stack1 = new LinkedList<Integer>();
		int[] intL1 = { 1, 2, 3, 4 };
		for (int i : intL1) {
			stack1.push(i);
		}
		System.out.println("Stack1:" + stack1);

		LinkedList<Integer> stack2 = new LinkedList<Integer>();
		int[] intL2 = { 5, 6, 7, 8, 9, 0 };
		for (int i : intL2) {
			stack2.push(i);
		}
		System.out.println("Stack2:" + stack2);

		LinkedList<Integer> tmpStack1 = new LinkedList<Integer>();
		LinkedList<Integer> tmpStack2 = new LinkedList<Integer>();
		// Put all items from stack2 to tmpStack2.
		while (!stack2.isEmpty()) {
			tmpStack2.push(stack2.pop());
		}
		System.out.println("After moving stack2 to tmpStack2");
		System.out.println("Stack2:" + stack2);
		System.out.println("tmpStack2:" + tmpStack2);

		// Using tmpStack1 to move stack1 to the stack2 with relevant order
		while (!stack1.isEmpty()) {
			tmpStack1.push(stack1.pop());
		}
		System.out.println("After moving stack1 to tmpStack1");
		System.out.println("Stack1:" + stack1);
		System.out.println("tmpStack1:" + tmpStack1);

		while (!tmpStack1.isEmpty()) {
			stack2.push(tmpStack1.pop());
		}
		System.out.println("After moving tmpStack1 to stack2");
		System.out.println("Stack2:" + stack2);
		System.out.println("tmpStack1:" + tmpStack1);

		System.out.println("Now move tmpStack2 to Stack2");
		while (!tmpStack2.isEmpty()) {
			stack2.push(tmpStack2.pop());
		}
		System.out.println("After moving tmpStack2 to stack2");
		System.out.println("Stack2:" + stack2);
		System.out.println("Stack1:" + stack1);
		System.out.println("tmpStack1:" + tmpStack1);
		System.out.println("tmpStack2:" + tmpStack2);
	}

	public static void lab2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a line:");
		String s = sc.nextLine();
		if (s.equals(null) || s.equals("") || !s.contains(':' + "")) {
			System.out.println("N");
		} else {
			String[] tmp = s.split(":");
			if (tmp.length > 2) {
				System.out.println("More than 2 colon characters, we need 1, system exits.");
			} else {
				Queue<Character> left = new LinkedList<Character>();
				Queue<Character> right = new LinkedList<Character>();
				int index = s.indexOf(':');
				for (int i = 0; i < s.length(); i++) {
					if (i < index) {
						left.add(s.charAt(i));
					} else if (i > index) {
						right.add(s.charAt(i));
					}
				}
				System.out.println("Left:" + left);
				System.out.println("Right:" + right);
				if (left.size() > right.size()) {
					System.out.println("L");
				} else if (left.size() < right.size()) {
					System.out.println("R");
				} else if (left.containsAll(right)) {
					System.out.println("S");
				} else {
					System.out.println("D");
				}
			}
		}
		sc.close();
	}
}
