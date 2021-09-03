package developingefficientalgorithms;

//THROUGHOUT THIS CLASS, USE SECTION 22.8'8 ALGORITHM FOR FINDING THE CLOSEST PAIR OF POINTS USING A DIVIDE AND CONQUER ALGORITHM
public class Pair {
	Point p1;
	Point p2;

	public Pair() {

	}

	public Pair(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;

	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

//	/* Return the distance of the closest pair of points */
//	public static Pair getClosestPair(double[][] points) {
//
//		return null;
//
//	}
//
//	/* Return the distance of the closest pair of points */
//	public static Pair getClosestPair(Point[] points) {
//
//		return null;
//
//	}
//
//	/* see book for details */
//	public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY) {
//		return null;
//
//	}
//
//	/** compute distance between two points p1 and p2 */
//	public static double distance(Point p1, Point p2) {
//		double distanceX = p1.getX() - p2.getX();
//		double distanceY = p1.getY() - p2.getY();
//		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
//
//		if (distance < 0) {
//			distance = distance * -1;
//		}
//
//		return distance;
//
//	}
//
//	public static double distance(double x1, double y1, double x2, double y2) {
//		return y2;
//
//	}

	public static double getDistance(Point p1, Point p2) {
		double distanceX = p1.getX() - p2.getX();
		double distanceY = p1.getY() - p2.getY();
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

		if (distance < 0) {
			distance = distance * -1;
		}

		return distance;

	}
}
