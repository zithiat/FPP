package day07;

import java.util.Arrays;

public class Merge {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7, 9, 11, 13 };
		int[] arr2 = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		Merge m = new Merge();
		int[] result = m.merge(arr1, arr2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("New test with sort method");
		int[] arr3 = { 2, 23, 43, 11, 23, 42 };
		System.out.println("Before sort:\t"+ Arrays.toString(arr3));
		System.out.println("After sort:\t"+ Arrays.toString(m.sort(arr3)));
		int[] arr4 = { 9, 21, 10, 3, 1, 8 };
		System.out.println("Before sort:\t"+ Arrays.toString(arr4));
		System.out.println("After sort:\t"+ Arrays.toString(m.sort(arr4)));
		int[] result1 = m.merge(m.sort(arr3), m.sort(arr4));
		System.out.println("Merged:\t\t" + Arrays.toString(result1));
	}

	public int[] merge(int[] arr1, int[] arr2) {
		if (arr1 == null)
			return arr2;
		if (arr2 == null)
			return arr1;
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] retVal = new int[len1 + len2];

		return recursiveMerge(retVal, 0, arr1, arr2);
	}

	private int[] recursiveMerge(int[] returnVal, int nextAvailPos, int[] first, int[] second) {
		if (first.length == 0) {
			System.arraycopy(second, 0, returnVal, nextAvailPos, second.length);
			return returnVal;
		}

		if (second.length == 0) {
			System.arraycopy(first, 0, returnVal, nextAvailPos, first.length);
			return returnVal;
		}

		if (first[0] <= second[0]) {
			returnVal[nextAvailPos] = first[0];
			return recursiveMerge(returnVal, nextAvailPos + 1, remove0th(first), second);
		} else {
			returnVal[nextAvailPos] = second[0];
			return recursiveMerge(returnVal, nextAvailPos + 1, first, remove0th(second));
		}
	}

	private int[] remove0th(int[] arr) {
		return Arrays.copyOfRange(arr, 1, arr.length);
	}
	
	private int[] sort(int[] ar) {
		for (int i = 0; i < ar.length - 1; i++) {
		      int min = i;
		      for (int j = i + 1; j < ar.length; j++) {
		            if (ar[j] < ar[min]) {
		            	min = j;
		            }
		      }
		      int temp = ar[i];
		      ar[i] = ar[min];
		      ar[min] = temp;
		}
		return ar;
	}
}
