package Recursion;

public class RecursiveBinarySearch {
	public static void main(String[] args) {
		int[] list = new int[10];
		int key = 7;

		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		System.out.println(recursiveBinarySearch(list, key));
	}

	public static int recursiveBinarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		return resursiveBinarySearch(list, key, low, high);
	}

	private static int resursiveBinarySearch(int[] list, int key, int low, int high) {
		if (low > high) {
			return -low - 1;
		}
		int mid = (low + high) / 2;
		if (key < list[mid]) {
			return resursiveBinarySearch(list, key, low, mid - 1);
		} else if (key == list[mid]) {
			return mid;
		} else {
			return resursiveBinarySearch(list, key, mid + 1, high);
		}
	}

}
