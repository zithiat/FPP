import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class MySort {

	public static void main(String[] args) {
		sortInt();
		sortString();
		arrayCopy();
		testHashMap();
	}
	
	public static void sortInt() {
		int[] arr = {1, 5, 8, 2, 9, 4, 10, 30, 22};
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int tmp = arr[index];
			arr[index] = arr[i];
			arr[i] = tmp;			
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sortString() {
		String[] arr = {"abdc", "a123", "jjd", "832", "eeef", "uuu", "7928s"};
		
		for(int i = 0; i < arr.length; i++) {
			int idx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[idx]) < 0) {
					idx = j;
				}
			}
			String tmp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void arrayCopy() {
		int[] arr = {1, 5, 8, 2, 9, 4, 10, 30, 22};
		int[] newArr = new int[10];
		System.arraycopy(arr, 2, newArr, 2, 4);
		System.out.println(Arrays.toString(newArr));
	}
	
	public static void testHashMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10; i++) {
			map.put("key-" + i, "value-" + i);
		}
		//System.out.println(map);
		
//		for (Entry<String, String> e : map.entrySet()) {
//			System.out.println("Key="+e.getKey() + "<>value="+e.getValue());
//		}
		
		SortedSet<String> keys = new TreeSet<String>(map.keySet());
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			String value = map.get(key);
			System.out.println("Key="+key + "<>value="+value);
		}
	}
}
