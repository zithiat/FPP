package day16;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MyHashTable {
	private static final int INITIAL_SIZE;
	static {
		INITIAL_SIZE = 19;
	}
	private int tableSize;
	private LinkedList[] table;

	public MyHashTable() {
		this(INITIAL_SIZE);
	}

	public MyHashTable(int tableSize) {
		this.tableSize = tableSize;
		table = new LinkedList[tableSize];
	} // an array of LinkedList objects.

	public static void main(String[] args) {
		String namePrefix = "Key-";
		String phonePrefix = "Value-";
		System.out.print("Enter number for a hashtable:");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		MyHashTable mht = new MyHashTable(num);
		for (int i = 0; i < num - 1; i++) {
			String s = String.format("%02d", i);
			mht.put(namePrefix + s, phonePrefix + s);
			if (i % 2 == 0 && i != 0) {
				mht.put(namePrefix + s, phonePrefix + s);
			} 
			if (i % 4 == 0 && i != 0) {
				mht.put(namePrefix + s, phonePrefix + s);
			} 
		}
		for (int i = 0; i < num; i++) {
			String key = namePrefix + String.format("%02d", i);
			if (mht.get(key) != null)
				System.out.println("key:" + key + " && value:" + mht.get(key));
		}
		
		System.out.println("Size of MyHashTable:" + mht.size());
		System.out.println("Longest Size of MyHashTable:" + mht.longestSize());
		System.out.println("Number of empty cell in MyHashTable:" + mht.numEmptyCell());
		while (true) {
			System.out.println("Enter a key to find (to quit, enter QUIT):");
			String input = sc.nextLine();
			if (null == input || input.equals("")) {
				System.out.println("Input empty");
			} else if (!input.equals("QUIT")){
				String output = (String) mht.get(input);
				if (null == output) {
					System.out.println("Not found for " + input);
				} else {
					System.out.println("Found:\n\tKey:" + input + " & value:" + output);
				}
			} else {
				break;
			}
		}
		sc.close();
	}
	
	public void put(Object key, Object value) {
		// disallow null keys
		if (key == null)
			return;

		// get the "big" integer corresponding to the object
		// assumes key is not null
		int hashcode = key.hashCode();

		// compress down to a table slot
		int hash = hashM(hashcode);

		// put the value and the key into an Entry object
		// which will be placed in the table in the
		// slot ( namely, hash)

		// allows a null value
		Entry e = new Entry(key, value);

		if (table[hash] != null) {
			Iterator i1 = table[hash].iterator();
			while(i1.hasNext()) {
				Entry e1 = (Entry) i1.next();
				if (e1.key.equals(e.key)) {
					System.out.println("Same key detected:" + e.key);
					break;
				}
			}
		}
		// now place it in the table
		else {
			table[hash] = new LinkedList();
		}
		// this allows duplicate keys
		table[hash].add(e);
	}
	
	public Object get(Object key) {
		// null key not allowed
		if (key == null)
			return null;
		// get the "big" integer corresponding to the object
		int hashcode = key.hashCode();

		// compress down to a table slot
		int hash = hashM(hashcode);

		// now look for the desired Entry
		Entry e = null;

		// First we should make sure that table[hash]
		// is Not null. If it is null, then the
		// Entry is Not there. (JL 11-2009).
		Iterator it = null;
		if (table[hash] != null)
			it = table[hash].iterator();
		if (it != null) {
			while (it.hasNext()) {
				e = (Entry) it.next();
				if (e.key.equals(key)) {
					return e.value;
				}
			}
		}
		return null; // Not found.
	}
	
	public int size() {
		int size = 0;
		Iterator it = null;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println(table[i]);
				it = table[i].iterator();
				while (it.hasNext()) {
					if ((Entry) it.next() != null) {
						size++;
					}
				}
			}
		}
		return size;
	}

	public int longestSize() {
		int longestSize = 0;
		int tmpSize = 0;
		Iterator it = null;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				it = table[i].iterator();
				tmpSize = 0;
				while (it.hasNext()) {
					if ((Entry) it.next() != null) {
						tmpSize++;
					}
				}
			}
			if (longestSize < tmpSize) {
				longestSize = tmpSize;
			}
		}
		return longestSize;
	}
	
	public int numEmptyCell() {
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null)
				count++;
		}
		return count;
	}

	public String toString() {
		String n = System.getProperty("line.separator");// a new line
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < table.length; ++i) {
			if (table[i] != null) {
				Iterator it = table[i].iterator();// For the
				// LinkedList at table[i]

				Entry next = null;
				while (it.hasNext()) {
					next = (Entry) it.next();
					sb.append(next);
				}
			}
		}
		return sb.toString();
	}

	// In the java file this method might be called hash
	private int hashM(int bigNum) {
		return Math.abs(bigNum % tableSize); // we should use Math.abs() here for the absolute value
	}

	private class Entry {
		private Object key;
		private Object value;

		Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return key.toString() + "->" + value.toString();
		}
	}
}
