package lists_stacks_queues;

import generics.Colorable;

public class Circle extends AbstractGeometricObject
		implements Comparable<AbstractGeometricObject>, Colorable<AbstractGeometricObject> {
	protected double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return (Math.PI * (radius * radius));
	}

	public double getPerimeter() {
		return (2 * radius) * (Math.PI);
	}

	public int compareTo(AbstractGeometricObject o) {
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		else
			return 0;
	}

	@Override
	public void howToColor() {
		// TODO Auto-generated method stub

	}

}
