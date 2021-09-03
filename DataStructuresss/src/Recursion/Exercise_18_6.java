package Recursion;

import java.util.Scanner;

public class Exercise_18_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number");
		double n = input.nextDouble();
		System.out.println("the sum of the series to your number is " + seriesSum(n));
	}

	public static double seriesSum(double i) {
		if (i == 1) {// Base Case
			return i / (i + 1);
		} else {// Recursive Case
			return (i / (i + 1) + seriesSum(i - 1));// Recursive Call
		}
	}
}