package day02;
public class Prog2 {

	public static void main(String[] args) {
		float f1 = 1.27f;
		float f2 = 3.881f;
		float f3 = 9.6f;
		int sumInt = (int) (f1 + f2 + f3);
		int sumInt2 = (int)f1 + (int)f2 + (int)f3;
		int sumIntRound = Math.round(f1 + f2 + f3);
		System.out.println("The sum of the floats as an integer: " + sumInt);
		System.out.println("The sum of the floats (casted to integer before sum) as an integer: " + sumInt2);
		System.out.println("The sum of the floats as an integer by rounding: " + sumIntRound);
	}
}
