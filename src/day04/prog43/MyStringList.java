package day04.prog43;

import java.util.Arrays;

public class MyStringList {
	private String[] strArray;
	private int actualSize = 0;
	
	public MyStringList() {
		strArray = new String[1];
	}
	public void add(String s) {
		if (strArray.length - actualSize <= 0) {
			increaseSize();
		}
		strArray[actualSize++] = s;
	}
	
	public String get(int i) {
		if (i < strArray.length) {
			return strArray[i - 1];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public boolean find(String s) {
		boolean found = false;
		for (String subStr : strArray) {
			if (subStr.equals(s)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public boolean remove(String s) {
		boolean removeFlag = false;
		int foundIndex = -1;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].equals(s)) {
				foundIndex = i;
				removeFlag = true;
				break;
			}
		}
		
		strArray[foundIndex] = null;
		int tmpIndex = foundIndex;
		while (tmpIndex < actualSize && tmpIndex != actualSize -1) {
			strArray[tmpIndex] = strArray[tmpIndex + 1];
			strArray[tmpIndex + 1] = null;
			tmpIndex++;
		}
		// reduce the array size and its counter
		actualSize--;
		decreaseSize();
		return removeFlag;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(strArray);
	}
	
	public int size() {
		return actualSize;
	}
	
	private void increaseSize() {
		strArray = Arrays.copyOf(strArray, strArray.length + 1);
		System.out.println("\tIncreasing size...");
	}
	
	private void decreaseSize() {
		strArray = Arrays.copyOf(strArray, strArray.length - 1);
		System.out.println("\tDecreasing size...");
	}
}