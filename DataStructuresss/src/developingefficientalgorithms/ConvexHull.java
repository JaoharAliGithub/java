package developingefficientalgorithms;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.*;
import java.util.Scanner;

public class ConvexHull {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("How many points are in the set?");
		int numPoints = input.nextInt();
		System.out.println("Enter " + numPoints + " points: ");
		double[][] s = new double[numPoints][2];
		for (int i = 0; i < numPoints; i++) {
		}
		System.out.println("The convex hull is ");
	}

	public static ArrayList<Point2D> getConvexHull(double[][] s) {

		return null;
	}
	
	public static double[][] generatePoints(){
		
		return null;
		
	}
}

class MyPoint implements Comparable<MyPoint> {
	double x, y;

	MyPoint rightMostLowestPoint;

	MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setRightmostLowestPoint(MyPoint p) {
		rightMostLowestPoint = p;
	}

	@Override
	public int compareTo(MyPoint o) {
		
		return 0;

	}
}