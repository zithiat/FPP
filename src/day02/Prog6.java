package day02;

public class Prog6 {

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println("No argument, application exits");
			System.exit(1);
		} else {
			System.out.print("Original list: [ ");
			for (String s : args) {
				System.out.print(s + " ");
			}
			System.out.println("]");
			System.out.print("List without duplicates: [ ");
			for (int i = 0; i < args.length - 1; i++) {
				for (int j = i + 1; j < args.length; j++) {
					if (args[i].equals(args[j])) {
						args[j] = "";
					}
				}
			}
			for (String s1 : args) {
				if (!"".equals(s1)) {
					System.out.print(s1 + " ");
				}
			}
			System.out.println("]");
		}
	}
}
