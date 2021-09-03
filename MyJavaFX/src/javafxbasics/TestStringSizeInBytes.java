package javafxbasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;

public class TestStringSizeInBytes {

	public static void main(String[] args) throws IOException {

		String asciiUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String asciiLowerCase = asciiUpperCase.toLowerCase();
		String digits = "1234567890";
		String asciiChars = asciiUpperCase + asciiLowerCase + digits;

		RandomAccessFile inout = new RandomAccessFile("testingstringsize.dat", "rw");

		inout.setLength(0);

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("testingstringsize.dat", true));
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("testingstringsize.dat"));

		long length = 0;

		String size1 = generateRandomString(1, asciiChars);
		inout.writeUTF(size1);
		length = inout.length();
		System.out.println("the size of string of length 1 in bytes is: " + length);
		inout.setLength(0);

		String size2 = generateRandomString(2, asciiChars);
		inout.writeUTF(size2);
		length = inout.length();
		System.out.println("the size of string of length 2 in bytes is: " + length);
		inout.setLength(0);

		String size3 = generateRandomString(3, asciiChars);
		inout.writeUTF(size3);
		length = inout.length();
		System.out.println("the size of string of length 3 in bytes is: " + length);
		inout.setLength(0);

		String size4 = generateRandomString(3, asciiChars);
		inout.writeUTF(size4);
		length = inout.length();
		System.out.println("the size of string of length 4 in bytes is: " + length);
		inout.setLength(0);

		String size5 = generateRandomString(5, asciiChars);
		inout.writeUTF(size5);
		length = inout.length();
		System.out.println("the size of string of length 5 in bytes is: " + length);
		inout.setLength(0);

		String size10 = generateRandomString(10, asciiChars);
		inout.writeUTF(size10);
		length = inout.length();
		System.out.println("the size of string of length 10 in bytes is: " + length);
		inout.setLength(0);

		String size20 = generateRandomString(20, asciiChars);
		inout.writeUTF(size20);
		length = inout.length();
		System.out.println("the size of string of length 20 in bytes is: " + length);
		inout.setLength(0);

		for (int i = 1; i < 100; i++) {
			inout.setLength(0);
			inout.writeUTF(generateRandomString(i, asciiChars));
			length = inout.length();
			System.out.println("the size of string of length " + i + " in bytes is: " + length);
		}

	}

	private static String generateRandomString(int length, String seedChars) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		Random rand = new Random();
		while (i < length) {
			sb.append(seedChars.charAt(rand.nextInt(seedChars.length())));
			i++;
		}
		return sb.toString();
	}

}
