package day15;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MyBST {

	/*
	 * 15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 10,
	 * 9, 8, 7, 6 ,5, 4, 3, 2, 1
	 */
	private BinaryNode root;
	private int count = 0;
	private int leavesCount = 0;

	public MyBST() {
		root = null;
	}

	/**
	 * 
	 * @param i
	 *            mode of order -1 PreOrder 0 Inorder 1 PostOrder
	 */
	public void printTree(int i) {
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			switch (i) {
			case -1:
				printTreePreOrder(root);
				break;
			case 0:
				printTreeInOrder(root);
				break;
			case 1:
				printTreePostOrder(root);
				break;
			default:
				break;
			}
		}
	}

	public void printTreePreOrder(BinaryNode n) { // PreOrder: Visit, Left, Right
		if (n != null) {
			System.out.print(n.element + " ");
			printTreePreOrder(n.left);
			printTreePreOrder(n.right);
		}
	}

	public void printTreeInOrder(BinaryNode n) { // InOrder: Left, Visit, Right
		if (n != null) {
			printTreeInOrder(n.left);
			System.out.print(n.element + " ");
			printTreeInOrder(n.right);
		}
	}

	public void printTreePostOrder(BinaryNode n) { // PostOrder: Left, Right, Visit
		if (n != null) {
			printTreePostOrder(n.left);
			printTreePostOrder(n.right);
			System.out.print(n.element + " ");
		}
	}

	public void insert(Integer i) {
		if (root == null) {
			root = new BinaryNode(i);
			return;
		}

		BinaryNode n = root;
		boolean inserted = false;
		while (!inserted) {
			if (i.compareTo(n.element) < 0) { // go left
				if (n.left == null) {
					n.left = new BinaryNode(i);
					inserted = true;
				} else {
					n = n.left;
				}
			} else if (i.compareTo(n.element) > 0) { // go right
				if (n.right == null) {
					n.right = new BinaryNode(i);
					inserted = true;
				} else {
					n = n.right;
				}
			}
		}
	}

	public int countNodes() {
		if (root == null) {
			return 0;
		} else {
			return countNodes(root);
		}
	}

	public int countNodes(BinaryNode n) {
		if (n != null) {
			count++;
			countNodes(n.left);
			countNodes(n.right);
		}
		return count;
	}

	public int countLeaves() {
		if (root == null) {
			return 0;
		} else {
			return countLeaves(root);
		}
	}
	
	public int countLeaves(BinaryNode n) {
		if (n != null) {
			if (n.left == null && n.right == null) {
				leavesCount++;
			} else {
				countLeaves(n.left);
				countLeaves(n.right);
			}
		}
		return leavesCount;
	}

	private class BinaryNode {
		Integer element;
		BinaryNode left;
		BinaryNode right;

		BinaryNode(Integer element) {
			this(element, null, null);
		}

		BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25 };
		MyBST myBst1 = new MyBST();
		for (int i : arr1) {
			myBst1.insert(i);
		}
		System.out.println("Input: " + Arrays.toString(arr1));
		System.out.println("PrintTree with PreOrder traversal");
		myBst1.printTree(-1);
		System.out.println();
		System.out.println("PrintTree with InOrder traversal");
		myBst1.printTree(0);
		System.out.println();
		System.out.println("PrintTree with PostOrder traversal");
		myBst1.printTree(1);
		System.out.println();
		System.out.println("Count nodes:" + myBst1.countNodes());
		System.out.println("Count leaves:" + myBst1.countLeaves());
		System.out.println("\n");

		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		MyBST myBst2 = new MyBST();
		for (int i : arr2) {
			myBst2.insert(i);
		}
		System.out.println("Input: " + Arrays.toString(arr2));
		System.out.println("PrintTree with PreOrder traversal");
		myBst2.printTree(-1);
		System.out.println();
		System.out.println("PrintTree with InOrder traversal");
		myBst2.printTree(0);
		System.out.println();
		System.out.println("PrintTree with PostOrder traversal");
		myBst2.printTree(1);
		System.out.println();
		System.out.println("Count nodes:" + myBst2.countNodes());
		System.out.println("Count leaves:" + myBst2.countLeaves());
		System.out.println("\n");

		int[] arr3 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		MyBST myBst3 = new MyBST();
		for (int i : arr3) {
			myBst3.insert(i);
		}
		System.out.println("Input: " + Arrays.toString(arr3));
		System.out.println("PrintTree with PreOrder traversal");
		myBst3.printTree(-1);
		System.out.println();
		System.out.println("PrintTree with InOrder traversal");
		myBst3.printTree(0);
		System.out.println();
		System.out.println("PrintTree with PostOrder traversal");
		myBst3.printTree(1);
		System.out.println();
		System.out.println("Count nodes:" + myBst3.countNodes());
		System.out.println("Count leaves:" + myBst3.countLeaves());
		System.out.println();
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		for (int i : arr1) {
			map.put(i, "Data-" + i);
		}
		int countNodeOfMap = 0;
		Set<Entry<Integer, String>> set = map.entrySet();
		Iterator<Entry<Integer, String>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> e = (Map.Entry<Integer, String>) iterator.next();
			System.out.print("Key:" + e.getKey() + " - Value:");
			System.out.println(e.getValue());
			countNodeOfMap++;
		}
		System.out.println("Nodes count:" + countNodeOfMap);
	}
}
