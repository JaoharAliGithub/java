package Recursion;

import java.lang.Character;
import java.util.Scanner;

public class Exercise_18_14 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string and I will calculate the number of uppercase characters within it");
		String str = input.next();
		System.out.println("The number of uppercase characters is: " + upperCase(str));
	}

	public static int upperCase(String string) {
		int highIndex = string.length() - 1;
		int upperCount = 0;
		return upperCase(string, highIndex, upperCount);
	}

	public static int upperCase(String str, int highIndex, int upperCount) {
		if (highIndex < 0) {
			return upperCount;
		} else if (Character.isUpperCase(str.charAt(highIndex)) == true) {
			return upperCase(str, highIndex - 1, upperCount += 1);
		} else {
			return upperCase(str, highIndex - 1, upperCount);
		}
	}

}
