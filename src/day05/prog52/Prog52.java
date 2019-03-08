package day05.prog52;

public class Prog52 {

	public static void main(String[] args) {
		ClosedCurve[] objects = { new Triangle(4, 5, 6), new Square(3), new Rectangle(3, 7), new Circle(3)};
		// compute areas
		for (ClosedCurve cc : objects) {
			System.out.println("The area of this " + cc.getClass().getSimpleName() + " is " + String.format("%,.2f", cc.computeArea()));
		}
	}

}
