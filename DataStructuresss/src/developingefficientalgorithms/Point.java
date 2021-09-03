package developingefficientalgorithms;

public class Point extends Object implements Comparable<Point> {
	double x = 0, y = 0;

	public Point() {

	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double newX) {
		this.x = newX;
	}

	public double getY() {
		return y;
	}

	public void setY(double newY) {
		this.y = newY;
	}

	@Override
	public int compareTo(Point o) {
		if (this.getX() > o.getX())
			return 1;
		else if (this.getX() < o.getX())
			return -1;
		else {
			if (this.getY() > o.getY()) {
				return 1;
			} else if (this.getY() < o.getY()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public String toString() {
		return x + " " + y + " ";

	}

}
