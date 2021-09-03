package papa_sorting_algorithm;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		/*
		 * making array of 1000 double value elements and then filling with randomly
		 * generated values from 0 - 10000
		 */
		double[] arr = new double[1000];

		for (int i = 0; i < arr.length; i++) {
			Random rand = new Random();
			arr[i] = rand.nextInt((10000 - 0) + 1) + 0;
		}

	}

	/*
	 * sorting algorithm (refer to personal notebook) to sort any array of numerical
	 * values
	 */
	public static void sort(double[] arr) {
		/* given a point in the array and compare it with the 
	}

}
