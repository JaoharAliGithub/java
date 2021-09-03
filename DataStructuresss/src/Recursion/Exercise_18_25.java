package Recursion;

import java.util.Scanner;

public class Exercise_18_25 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to see its possible permutations");
		String permute = input.next();
		displayPermutation(permute);
	}

	public static void displayPermutation(String s) {
		displayPermutation("", s);
	}

	public static void displayPermutation(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		if (s2 == "") {
			System.out.println(s1);
		} else {
			for (int i = 0; i < s2.length(); i++) {
				s1 += s2.charAt(i);
				sb.deleteCharAt(s2.charAt(i));
			}
			displayPermutation(s1, s2);
		}
	}

}
