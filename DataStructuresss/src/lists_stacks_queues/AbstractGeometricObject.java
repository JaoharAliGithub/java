package lists_stacks_queues;

import generics.Colorable;

public abstract class AbstractGeometricObject
		implements Comparable<AbstractGeometricObject>, Colorable<AbstractGeometricObject> {
	protected String color = "white";
	protected boolean filled;
	private java.util.Date dateCreated;

	protected AbstractGeometricObject() {
		dateCreated = new java.util.Date();
	}

	protected AbstractGeometricObject(String newColor, boolean newFilled) {
		this.color = newColor;
		this.filled = newFilled;
		dateCreated = new java.util.Date();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

	public abstract double getArea();

	public abstract double getPerimeter();

	public int compareTo(AbstractGeometricObject o) {
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		else
			return 0;
	}

	/** Abstract method getMax */
	public static AbstractGeometricObject max(AbstractGeometricObject o1, AbstractGeometricObject o2) {
		if (o1.compareTo(o2) == -1) {
			return o2;
		}
		return o2;
	}

	public void howToColor() {

	}
	public AbstractGeometricObject clone(AbstractGeometricObject o) throws CloneNotSupportedException {
		return (AbstractGeometricObject) super.clone();
		
		
	}
}
