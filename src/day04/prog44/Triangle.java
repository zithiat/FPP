package day04.prog44;

public class Triangle {

	private double height;
	private double base;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}

	public double getBase() {
		return base;
	}

	public double computeArea() {
		return 0.5 * (base * height);
	}
}
