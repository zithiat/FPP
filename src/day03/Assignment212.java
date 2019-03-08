package day03;

import java.util.Arrays;

public class Assignment212 {

	public static void main(String[] args) {
		int[] testArr = { 2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22 };
		System.out.println("Input array:" + Arrays.toString(testArr) + "\n");

		System.out.println("Question 1");
		System.out.println("Minimum value:" + min(testArr) + "\n");

		System.out.println("Question 2");
		System.out.println("Average value:" + average(testArr) + "\n");

		System.out.println("Question 3");
		letterCaseConverting("Hello There");

		System.out.println("Question 4");
		presentInterestData();
	}

	// Question 1
	// Find the minimum of the integer arrays
	static int min(int[] arrayOfInts) {
		int min = 0;
		for (int i = 0; i < arrayOfInts.length; i++) {
			if (arrayOfInts[i] < min) {
				min = arrayOfInts[i];
			}
		}
		return min;
	}

	// Question 2
	// Find the average of the integer array
	static int average(int[] arrayOfInts) {
		int average = 0;
		for (int n : arrayOfInts) {
			average += n;
		}
		return average / arrayOfInts.length;
	}

	// Question 3
	// Convert lowercase char to uppercase and vice versa
	static void letterCaseConverting(String str) {
		StringBuffer sb = new StringBuffer();
		System.out.println("Original string:" + str);
		sb.append(str);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= 'a' && c <= 'z') {
				sb.setCharAt(i, Character.toUpperCase(c));
			} else if (c >= 'A' && c <= 'Z') {
				sb.setCharAt(i, Character.toLowerCase(c));
			}
		}
		System.out.println("After converting:" + sb + "\n");
	}

	// Question 4
	// 3 rows, 6 columns, the first row with 10,000
	// columns: starting from 10% to %15 interest rate
	// a. Print average of each row
	// b. Print average of each column
	static void presentInterestData() {
		int rows = 3;
		int cols = 6;
		double[][] arr = new double[rows][cols];
		for (int i = 0; i < cols; i++) {
			arr[0][i] = 10000;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j] * (j + 10) / 100;
			}
		}

		// We convert from 2D array of double to String with .00 ending
		String[][] resultArr = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				resultArr[i][j] = String.format("%.2f", arr[i][j]);
			}
		}

		// To print out the 2D array
		System.out.println("The table of investment");
		for (int i = 0; i < rows; i++) {
			System.out.println(Arrays.toString(resultArr[i]));
		}
		System.out.println(); // add an empty line for easy presenting

		// Print average of each row
		double aveRow = 0;
		for (int i = 0; i < rows; i++) {
			for (double a : arr[i]) {
				aveRow += a;
			}
			System.out.println("Average of row " + (i + 1) + " = " + String.format("%.2f", aveRow / cols));
			aveRow = 0;
		}
		System.out.println(); // add an empty line for easy presenting

		// Print average of each col
		double aveCol = 0;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				aveCol += arr[j][i];
			}
			System.out.println("Average of col " + (i + 1) + " = " + String.format("%.2f", aveCol / rows));
			aveCol = 0;
		}
	}
}
