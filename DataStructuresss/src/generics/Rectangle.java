package generics;

public class Rectangle extends AbstractGeometricObject implements Comparable<AbstractGeometricObject>, Colorable<AbstractGeometricObject> {

	private double width;
	private double height;

	Rectangle() {

	}

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	Rectangle(String color, boolean filled, double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
		setColor(color);
		setFilled(filled);
	}

	double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPerimeter() {
		return 2 * (width + height);
	}

	public double getArea() {
		return width * height;
	}

	@Override
	public void howToColor() {
		// TODO Auto-generated method stub
		
	}

	
}