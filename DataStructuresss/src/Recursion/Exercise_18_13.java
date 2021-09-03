package Recursion;

import java.util.Scanner;

public class Exercise_18_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 8 integers");
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = input.nextInt();
		}

		System.out.println("The highest value is: " + max(arr));

	}

	public static int max(int[] arr) {
		int max = arr[arr.length - 1];
		return max(arr, arr.length - 1, max);
	}

	public static int max(int[] list, int index, int max) {
		if (index < 0) {
			return max;
		} else if (list[index] > max) {
			return max(list, index - 1, list[index]);
		} else
			return max(list, index - 1, max);

	}
}
