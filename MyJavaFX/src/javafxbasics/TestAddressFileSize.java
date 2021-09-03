package javafxbasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class TestAddressFileSize {

	public static void main(String[] args) throws IOException {
		RandomAccessFile inout = new RandomAccessFile("testingaddressobjectsize.dat", "rw");

		inout.setLength(0);

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("testingaddressobjectsize.dat", true));
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("testingaddressobjectsize.dat"));

		String asciiUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String asciiLowerCase = asciiUpperCase.toLowerCase();
		String digits = "1234567890";
		String asciiChars = asciiUpperCase + asciiLowerCase + digits;

		for (int i = 0; i < 100; i++) {
			String randomName = generateRandomString(32, asciiChars);
			String randomStreet = generateRandomString(32, asciiChars);
			String randomCity = generateRandomString(20, asciiChars);
			String randomState = generateRandomString(2, asciiChars);
			String randomZip = generateRandomString(5, asciiChars);

			Address address = new Address(randomName, randomStreet, randomCity, randomState, randomZip);
			output.writeObject(address);
		}

		int fileLength = (int) inout.length();
		System.out.println("The size of each address obj in bytes is: " + fileLength / 100);

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
