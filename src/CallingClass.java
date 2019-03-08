import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class CallingClass {

	private static Class<ClassOne> clsOne;
	private static Class<ClassTwo> clsTwo;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (null == s || s.equals("")) {
			System.out.println("Empty input");
		}
		try {
			switch (s) {
			case "One":
				clsOne = (Class<ClassOne>) Class.forName("ClassOne");
				break;
			case "Two":
				clsTwo = (Class<ClassTwo>) Class.forName("ClassTwo");
				break;
			default:
				break;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			if (clsOne != null) {
				ClassOne newOne = clsOne.getConstructor().newInstance(null);
				newOne.publicMethod();
				System.out.println(newOne.getInitStr());
			} else {
				ClassTwo newTwo = clsTwo.getConstructor().newInstance(null);
				newTwo.publicMethod();
				System.out.println(newTwo.getInitStr());
			}
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();

		}
		sc.close();
	}
}
