package day04.prog44;

import java.util.Scanner;

public class Prog44 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Rectangle
		System.out.println("Enter width:");
		double width = sc.nextDouble();
		System.out.println("Enter height:");
		double height = sc.nextDouble();
		Rectangle r = new Rectangle(width, height);
		System.out.println("Area of a rectangle is " + r.computeArea());
		
		// Triangle
		System.out.println("Enter base:");
		double base = sc.nextDouble();
		System.out.println("Enter height:");
		double tHeight = sc.nextDouble();
		Triangle t = new Triangle(base, tHeight);
		System.out.println("Area of a triangle is " + t.computeArea());
		
		// Circle
		System.out.println("Enter radius: ");
		double radius = sc.nextDouble();
		Circle c = new Circle(radius);
		System.out.println("Area of a circle is " + c.computeArea());
		
		sc.close();
	}
}
