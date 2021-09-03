package generics;

public class GenericSort {

	public static void main(String[] args) {
		Integer[] intArray = { Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(4),
				Integer.valueOf(3) };

		Double[] doubleArray = { Double.valueOf(1.32), Double.valueOf(4.5), Double.valueOf(2.5) };

		Character[] charArray = { Character.valueOf('a'), Character.valueOf('j'), Character.valueOf('r') };

		String[] stringArray = { "Tom", "Susan", "Kim" };

		sort(intArray);
		sort(doubleArray);
		sort(charArray);
		sort(stringArray);

		System.out.print("Sorted Integer objects: ");
		printList(intArray);
		System.out.print("Sorted Double objects: ");
		printList(doubleArray);
		System.out.print("Sorted Character objects: ");
		printList(charArray);
		System.out.print("Sorted String objects: ");
		printList(stringArray);
	}

	public static <E extends Comparable<E>> void sort(E[] list) {
		E currentMin;
		int currentMinIndex;

		for (int i = 0; i < list.length - 1; i++) {
			currentMin = list[i];
			currentMinIndex = i;

			for (int j = i + 1; j < list.length - 1; j++) {
				if (currentMin.compareTo(list[j]) > 0) {
					currentMin = list[i];
					currentMinIndex = j;
				}
			}

			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	public static void printList(Object[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			System.out.print(list[i] + " ");
			System.out.println();
		}
	}

}