package Recursion;

import java.util.Scanner;

public class Exercise_18_5 {
	static int charCount = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string and specify the character you want to know the occurences of");
		String str = input.next();
		char c = input.next().charAt(0);
		System.out.println("The number of uppercase characters is: " + count(str, c));
	}

	public static int count(String string, char a) {
		int highIndex = string.length() - 1;
		int charCount = 0;
		return count(string, a, highIndex, charCount);
	}

	public static int count(String str, char a, int highIndex, int charCount) {
		if (highIndex < 0) {
			return charCount;
		} else if ((str.charAt(highIndex)) == a) {
			return count(str, a, highIndex-1, charCount + 1);
		} else {
			return count(str, a, highIndex-1, charCount);
		}
	}

}
