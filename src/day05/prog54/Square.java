package day05.prog54;

public class Square extends ClosedCurve implements Polygon {
	double side;
	public Square(Double side){
		this(side.doubleValue());
	}
	
	public Square(double side) {
		this.side = side;
	}
	
	double computeArea() {
		return (side * side);
	}
	
	public int getNumberOfSides() {
		return 4;
	}

	public double computePerimeter() {
		return 4 * side;
	}
}
