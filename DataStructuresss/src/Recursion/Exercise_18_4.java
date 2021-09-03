package Recursion;

import java.util.Scanner;

public class Exercise_18_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number");
		double n = input.nextDouble();
		System.out.println("the sum of the series to your number is " + seriesSum(n));
	}

	public static double seriesSum(double n) {
		if (n == 1) {// Base Case
			return 1;
		} else {// Recursive Case
			return (1 / n + seriesSum(n - 1));// Recursive Call
		}

	}
}
