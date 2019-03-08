package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MyHashMap {
	
	private static HashMap<String, String> myHashMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of the map:");
		int size = Integer.parseInt(sc.nextLine());
		myHashMap = new HashMap<String, String>();
		String namePrefix = "Name-";
		String phonePrefix = "Phone-";
		String s;
		for (int i = 0; i < size; i++) {
			s = String.format("%02d", i);
			myHashMap.put(namePrefix + s, phonePrefix + s);
		}
		
		Iterator<String> it = myHashMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = myHashMap.get(key);
			System.out.println("key:" + key + ">>" + value);
		}
		
		while (true) {
			System.out.println("Enter a key to find (to quit, enter QUIT):");
			String input = sc.nextLine();
			if (null == input || input.equals("")) {
				System.out.println("Input empty");
			} else if (!input.equals("QUIT")){
				String output = myHashMap.get(input);
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
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Name-111");
		map.put(101, "Name-222");
		map.put(102, "Name-333");
		map.put(103, "Name-444");
		System.out.println("Initial list of elements: " + map);
		// Key-based removal
		System.out.println("Remove element with key 100");
		map.remove(100);
		System.out.println("Updated list of elements: " + map);
		System.out.println("Remove element with key 102 and Name-333");
		// key-value pair based removal
		map.remove(102, "Name-333");
		System.out.println("Updated list of elements: " + map);
	}
}
