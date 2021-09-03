package developingefficientalgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class divideandconquerpoints {
	public static void main(String[] args) {
		// Array of Point objects
		Point[] list = new Point[199];
		// Loop through the array and make random Point objects at each index
		for (int i = 0; i < 199; i++) {
			// Assigning the index i to a random generated X and Y Point object
			list[i] = generatePoints();
		}
		// Sorting the array using the books requirements by X value increasing (if X
		// are equal then go by Y value)
		sortList(list);
		// Printing the list using printArray method
		printArray(list);

		Point midPoint = list[99];
		Point[] sOne = new Point[100];
		Point[] sTwo = new Point[99];
		// Assigning first 100 elements in given list to the first array
		for (int i = 0; i < 100; i++) {
			sOne[i] = list[i];
		}
		// Assigning second 99 elements in given list to the second array
		for (int i = 100; i < list.length; i++) {
			sTwo[i - 100] = list[i];
		}

		Point[] pointsOrderedOnY = orderOnY(list);
		Point[] pointsOrderedOnX = orderOnX(list);

		// now we obtain the stripssvv
		LinkedList<Point> stripL = new LinkedList<Point>();
		LinkedList<Point> stripR = new LinkedList<Point>();

		Pair closePairS1 = distance(sOne);
		Pair closePairS2 = distance(sTwo);

		double d = Math.min(Pair.getDistance(closePairS1.getP1(), closePairS1.getP2()),
				Pair.getDistance(closePairS2.getP1(), closePairS2.getP2()));
		double d1 = Pair.getDistance(closePairS1.getP1(), closePairS1.getP2());
		double d2 = Pair.getDistance(closePairS2.getP1(), closePairS2.getP2());
		for (Point p : pointsOrderedOnY) {
			if (Arrays.asList(sOne).contains(p) && midPoint.getX() - p.getX() <= d) {
				stripL.add(p);
			} else if (Arrays.asList(sTwo).contains(p) && p.getX() - midPoint.getX() <= d) {
				stripR.add(p);
			}
		}

		// Algorithm for finding the closest pair in step 3

		Point[] q = new Point[100];

		d = Math.min(d1, d2);
		int r = 0;
		for (Point p : stripL) {
			while (r < stripR.size() && q[r].getY() <= p.getY() - d) {
				r++;

				int r1 = r;
				while (r1 < stripR.size() && Math.abs(q[r1].getY() - p.getY()) <= d) {
					if (distance(p, q[r1]) < d) {
						d = distance(p, q[r1]);
					}
					r1 = r1 + 1;
				}

			}
		}

	}

	public static Point[] orderOnX(Point[] arr) {
		Point[] list = new Point[199];
		for (int i = 0; i < arr.length; i++) {
			list[i] = arr[i];
		}

		int n = list.length;

		for (int i = 0; i < n - 1; i++) {

			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (list[j].getX() < list[minIndex].getX()) {
					minIndex = j;

					Point temp = list[minIndex];
					list[minIndex] = list[i];
					list[i] = temp;
				}
			}
		}

		return list;

	}

	public static Point[] orderOnY(Point[] arr) {

		Point[] list = new Point[199];
		for (int i = 0; i < arr.length; i++) {
			list[i] = arr[i];
		}

		int n = list.length;

		for (int i = 0; i < n - 1; i++) {

			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (list[j].getY() < list[minIndex].getY()) {
					minIndex = j;

					Point temp = list[minIndex];
					list[minIndex] = list[i];
					list[i] = temp;
				}
			}
		}

		return list;

	}

	// Selection Sort for the list of Points
	public static void sortList(Point[] list) {
		int n = list.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (list[j].compareTo(list[minIndex]) == -1) {
					minIndex = j;

					Point temp = list[minIndex];
					list[minIndex] = list[i];
					list[i] = temp;
				}
			}
		}
	}

// Loop through the list and print each element using toString method in Point Class
	public static void printArray(Point arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i].toString() + " ");
		System.out.println(arr.length);
	}

//Making random Point objects by just randomly making X and Y values, and assigning those as the contructor args for a new Point object
	public static Point generatePoints() {
		Random rand = new Random();
		int upperBound = 1000;
		int xRandom = rand.nextInt(upperBound);
		int yRandom = rand.nextInt(upperBound);

		return new Point(xRandom, yRandom);
	}

	public static Pair getClosestPair(double[][] points) {
		
		return null;

	}

	/* Return the distance of the closest pair of points */
	public static Pair getClosestPair(Point[] points) {
		return null;

	}

	public static Pair distance(Point[] pointsOrderedOnX) {
		Pair obj = new Pair(pointsOrderedOnX[0], pointsOrderedOnX[1]);
		for (int i = 0; i < pointsOrderedOnX.length; i++) {
			for (int j = i + 1; j < pointsOrderedOnX.length; j++) {
				if (distance(pointsOrderedOnX[i], pointsOrderedOnX[j]) < Pair.getDistance(obj.getP1(), obj.getP2())) {
					obj = new Pair(pointsOrderedOnX[i], pointsOrderedOnX[j]);
				}
			}
		}
		return obj;
	}

	/* see book for details */
//	public static Pair recursiveDistance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY) {
//		Pair obj = new Pair(pointsOrderedOnX[0], pointsOrderedOnX[1]);
//		if (low >= high) {
//			return obj;
//		} else if (distance(pointsOrderedOnX[low], pointsOrderedOnX[high]) < Pair.getDistance(obj.getP1(),
//				obj.getP2())) {
//
//			for (int i = 0; i < pointsOrderedOnX.length; i++) {
//				for (int j = i + 1; j < pointsOrderedOnX.length; j++) {
//					if (distance(pointsOrderedOnX[i], pointsOrderedOnX[j]) < Pair.getDistance(obj.getP1(),
//							obj.getP2())) {
//						obj = new Pair(pointsOrderedOnX[i], pointsOrderedOnX[j]);
//					}
//				}
//			}
//
//			return distance(pointsOrderedOnX, low + 1, high - 1, pointsOrderedOnY);
//		} else {
//			return distance(pointsOrderedOnX, low + 1, high - 1, pointsOrderedOnY);
//		}
//
//	}

	/** compute distance between two points p1 and p2 */
	public static double distance(Point p1, Point p2) {
		double distanceX = p1.getX() - p2.getX();
		double distanceY = p1.getY() - p2.getY();
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

		if (distance < 0) {
			distance = distance * -1;
		}

		return distance;

	}

	public static double distance(double x1, double y1, double x2, double y2) {
		double distanceX = x1 - x2;
		double distanceY = y1 - y2;
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

		if (distance < 0) {
			distance = distance * -1;
		}

		return distance;

	}

}

//public static Point[][] divideList(Point[] list) {
//Point midPoint = list[100];
//Point[] sOne = new Point[100];
//Point[] sTwo = new Point[99];
//// Assigning first 100 elements in given list to the first array
//for (int i = 0; i < 100; i++) {
//	sOne[i] = list[i];
//}
//// Assigning second 99 elements in given list to the second array
//for (int i = 100; i < list.length; i++) {
//	sTwo[i - 100] = list[i];
//}
//Point[][] bothLists = new Point[1][2];
//bothLists[0] = sOne;
//bothLists[1] = sTwo;
//
//return bothLists;
//}
