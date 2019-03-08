package day05.prog54;

public class Rectangle extends ClosedCurve implements Polygon {
	double width;
	double length;
	
	public Rectangle(Double width, Double length) {
		this(width.doubleValue(), length.doubleValue());
	}
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	double computeArea() {
		return (width * length);
	}
	
	public int getNumberOfSides() {
		return 4;
	}

	public double computePerimeter() {
		return 2 * (width + length);
	}
}
