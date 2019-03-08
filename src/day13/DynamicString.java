package day13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DynamicString {
	static String cmdTxt = "Enter command ->";
	static String strNameTxt = "Enter string name ->";
	static String strStringTxt = "Enter text ->";
	static String strTrgTxt = "Enter target ->";
	static LinkedList<Character> listA = null;
	static LinkedList<Character> listB = null;
	static LinkedList<Character> listC = null;
	
	public static void main(String[] args) {
		
		LinkedList<Character> target = new LinkedList<Character>();
		
		Scanner sc = new Scanner(System.in);
		char cmd;
		while (true) {
			System.out.print(cmdTxt);
			cmd = sc.nextLine().charAt(0);
			if (cmd == 'Q') {
				System.out.println("System exits.");
				break;
			} else {
				if (cmd == 'R') { // ReadString
					System.out.print(strNameTxt);
					cmd = sc.nextLine().charAt(0);
					System.out.print(strStringTxt);
					switch (cmd) {
					case 'A':
						listA = ReadString(sc.nextLine());
						break;
					case 'B':
						listB = ReadString(sc.nextLine());
						break;
					case 'C':
						listC = ReadString(sc.nextLine());
						break;
					default: 
						break;
					} 
				} else {
					if (cmd == 'C') { // Concatenate
						System.out.print(strTrgTxt);
						cmd = sc.nextLine().charAt(0);
						switch (cmd) {
						case 'A':
							target = listA;
							listA = target;
							break;
						case 'B':
							target= listB;
							listB = target;
							break;
						case 'C':
							target= listC;
							listC = target;
							break;
						default:
							break;
						}
						System.out.print(strNameTxt);
						cmd = sc.nextLine().charAt(0);
						switch (cmd) {
						case 'A':
							listA = Concatenate(target, listA);
							break;
						case 'B':
							target = Concatenate(target, listB);
							break;
						case 'C':
							listC = Concatenate(target, listC);
							break;
						default:
							break;
						}
					} else {
						if (cmd == 'W') {
							System.out.print(strNameTxt);
							cmd = sc.nextLine().charAt(0);
							switch (cmd) {
							case 'A':
								WriteString(listA);
								break;
							case 'B':
								WriteString(listB);
								break;
							case 'C':
								WriteString(listC);
								break;
							default:
								break;
							}
						}
					}
				}
			}
		}
		sc.close();
		
//		LinkedList<Character> a = ReadString("abcdef");
//		LinkedList<Character> b = ReadString("123456");
//		System.out.println("Found=" + Search("cd", a, 1));
//		WriteString(Concatenate(a, b));
//		System.out.println("Insert");
//		LinkedList<Character> res = Insert(a, b, 2);
//		WriteString(res);
//		System.out.println("\nDelete");
//		res = Delete(res, 2, 6);
//		WriteString(res);
	}
	
	public static LinkedList<Character> ReadString(String s) {
		LinkedList<Character> res = new LinkedList<Character>();
		if (!s.equals(null)) {
			for (int i = 0; i < s.length(); i++) {
				res.add(s.charAt(i));
			}
			return res;
		}
		return null;
	}

	public static void WriteString(LinkedList<Character> ll) {
		if (ll == null)
			return;
		Iterator<Character> it = ll.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
	}

	public static LinkedList<Character> Clear(LinkedList<Character> ll) {
		return null;
	}

	public static int Len(LinkedList<Character> ll) {
		int len = 0;
		if (ll == null)
			return 0;
		Iterator<Character> it = ll.iterator();
		while (it.hasNext()) {
			it.next();
			len++;
		}
		return len;
	}

	public static boolean Equal(LinkedList<Character> ll1, LinkedList<Character> ll2) {
		if (ll1 == null || ll2 == null || ll1.size() != ll2.size())
			return false;
		Iterator<Character> it1 = ll1.iterator();
		Iterator<Character> it2 = ll2.iterator();
		while (it1.hasNext()) {
			char c1 = it1.next();
			char c2 = it2.next();
			if (c1 != c2) {
				return false;
			}
		}
		return true;
	}
	
	public static LinkedList<Character> Concatenate(LinkedList<Character> target, LinkedList<Character> source) {
		if (source != null) {
			target.addAll(source);
		}
		return target;
	}
	
	/**
	 * Insert one LinkedList into another LinkedList at the given position (i)
	 * Should use Node class, and only need to update two nodes:
	 * 	- the next of node at index (i) pointing to the header of the source list
	 * 	- the tail (or last node) of the source pointing to the node at index (i+1)
	 * 	- the previous of node at index (i+1) pointing to the tail of the source list
	 * 
	 *  However, here we use simply LinkedList without Node class. Hence, we will utilize
	 *  the Substring() methods to have 3 sub LinkedLists, then we use addAll() method of
	 *  the LinkedList for add three lists to 1 list.
	 * @param target
	 * @param source
	 * @param start
	 * @return
	 */
	public static LinkedList<Character> Insert(LinkedList<Character> target, LinkedList<Character> source, int start) {
		LinkedList<Character> headList = null;
		LinkedList<Character> tailList = null;
		LinkedList<Character> combined = new LinkedList<Character>();
		if (target != null && source != null) {
			int pos = 0;
			Iterator<Character> it = target.iterator();
			while (it.hasNext()) {
				if (pos == start) {
					headList = Substring(headList, target, 0, start + 1);
					tailList = Substring(tailList, target, start + 1, target.size() - start - 1);
					combined.addAll(headList);
					combined.addAll(source);
					combined.addAll(tailList);
					break;
				}
				it.next();
				pos++;
			}
		}
		return combined;
	}
	
	public static int Search(String s, LinkedList<Character> target, int start) {
		LinkedList<Character> toSearch = ReadString(s);
		LinkedList<Character> tmp = null;
		int pos = 0;
		if (target != null && start < target.size()) {
			Iterator<Character> it = target.iterator();
			while (it.hasNext()) {
				if (pos >= start && pos < target.size() - s.length() + 1) {
					tmp = Substring(tmp, target, pos, s.length());
					if (Equal(tmp, toSearch)) {
						return pos;
					}
					it.next();
				}
				pos++;
			}
		}
		return -1;
	}
	
	public static LinkedList<Character> Delete(LinkedList<Character> target, int start, int span) {
		LinkedList<Character> headList = null;
		LinkedList<Character> tailList = null;
		LinkedList<Character> combined = new LinkedList<Character>();
		if (target != null && start + span < target.size()) {
			int pos = 0;
			Iterator<Character> it = target.iterator();
			while (it.hasNext()) {
				if (pos == start) {
					headList = Substring(headList, target, 0, start + 1);
				} else if (pos == start + span) {
					tailList = Substring(tailList, target, pos + 1, target.size() - pos - 1);
					System.out.println(tailList);
					break;
				}
				it.next();
				pos++;
			}
			combined.addAll(headList);
			combined.addAll(tailList);
		} else {
			return target;
		}
		return combined;
	}
	
	public static LinkedList<Character> Substring(LinkedList<Character> target, LinkedList<Character> srcList, int start, int span) {
		if (srcList != null && start + span <= srcList.size()) {
			int pos = 0;
			target = new LinkedList<Character>();
			Iterator<Character> it = srcList.iterator();
			while (it.hasNext()) {
				char c = it.next();
				if (pos >= start && pos < start + span) {
					target.add(c);
				}
				pos++;				
			}
		}
		return target;
	}
}
