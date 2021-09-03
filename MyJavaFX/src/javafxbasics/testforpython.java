package javafxbasics;

import java.util.Random;
import java.util.Scanner;

class testforpython {
	public static void main(String[] args) {
		System.out.println("welcome to the dice game!");
		System.out.println("--------------------------");
		Scanner input = new Scanner(System.in);
		int total_wins = 0;
		int total_losses = 0;
		String playAgain = "Y";
		int gameCount = 1;
		while (playAgain == "Y") {
			System.out.println();
			System.out.println("Game " + gameCount);
			Random number = new Random();
			int die1 = number.nextInt((6) + 1);
			int die2 = number.nextInt((6) + 1);
			int die_sum = die1 + die2;
			int point = die_sum;
			if (die_sum == 7 || die_sum == 11) {
				total_wins += 1;
				System.out.println("You rolled ... " + die1 + " and " + die2);
				System.out.println("You Win! Congratulations");
			} else if (die_sum == 2 || die_sum == 3 || die_sum == 12) {
				total_losses += 1;
				System.out.println("You rolled ... " + die1 + " and " + die2);
				System.out.println("you lost. Better luck next time!");
			} else {
				die1 = number.nextInt((6) + 1);
				die2 = number.nextInt((6) + 1);
				die_sum = die1 + die2;
				if (die_sum == 7) {
					total_losses += 1;
					System.out.println("You rolled ... " + die1 + " and " + die2);
					System.out.println("you lost. Better luck next time!");
				} else if (die_sum == point) {
					total_wins += 1;
					System.out.println("You rolled ... " + die1 + " and " + die2);
					System.out.println("You Win! Congratulations");
				} else {
					boolean win = false;
					boolean loss = false;
					while (win == false && loss == false) {
						die1 = number.nextInt((6) + 1);
						die2 = number.nextInt((6) + 1);
						die_sum = die1 + die2;
						if (die_sum == 7) {
							total_losses += 1;
							System.out.println("You rolled ... " + die1 + " and " + die2);
							System.out.println("you lost. Better luck next time!");
						} else if (die_sum == point) {
							total_wins += 1;
							System.out.println("You rolled ... " + die1 + " and " + die2);
							System.out.println("You Win! Congratulations");
						} else {
							win = false;
							loss = false;
						}
					}
				}
			}
			gameCount += 1;
			System.out.println("Would you like to play again?");
			playAgain = input.next();
			if (playAgain == "N") {
				System.out.println("");
				System.out.println("You Won " + total_wins + " and lost " + total_losses);
				System.out.println("Thanks for playing the dice game! come back soon");
			}

		}
	}
}
