package day05.prog52;

public class Rectangle extends ClosedCurve {
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
}
