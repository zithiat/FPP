package day05.prog54;

public class Prog54 {

	public static void main(String[] args) {
		ClosedCurve[] objects = { new Triangle(4, 5, 6), new Square(3), new Rectangle(3, 7), new Circle(3) };
		// compute areas
		for (ClosedCurve cc : objects) {
			System.out.println("The area of this " + cc.getClass().getSimpleName() 
					+ " is " + String.format("%,.2f", cc.computeArea()));
		}

		Polygon[] plgs = { new Square(3), new Triangle(4, 5, 6), new Rectangle(3, 4) };
		for (Polygon p : plgs) {
			System.out.println("For this " + p.getClass().getSimpleName() 
					+ "\n  Number of sides = " + p.getNumberOfSides() 
					+ "\n  Perimeter = " + p.computePerimeter());
		}
	}
}
