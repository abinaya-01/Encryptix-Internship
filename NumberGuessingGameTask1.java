package com.example.mypractice.daily_task;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameTask1 {
    private static final int MAX_ATTEMPTS = 7; // Maximum number of attempts per round
    private static final int LOWER_BOUND = 1;  // Lower bound of the random number
    private static final int UPPER_BOUND = 100; // Upper bound of the random number

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasWon = false;

            System.out.println("\nI have selected a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess: ");

                int playerGuess;

                // Validate user input
                while (true) {
                    try {
                        playerGuess = Integer.parseInt(scanner.nextLine());
                        if (playerGuess < LOWER_BOUND || playerGuess > UPPER_BOUND) {
                            System.out.print("Please enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ": ");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. Please enter a valid integer: ");
                    }
                }

                if (playerGuess == numberToGuess) {
                    hasWon = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("You guessed it in " + (MAX_ATTEMPTS - attemptsLeft +1) + " attempt(s).");
                    roundsWon++;
                    break;
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
                }
            }

            roundsPlayed++;

            // Ask the player if they want to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Please respond with 'yes' or 'no': ");
                response = scanner.nextLine().trim().toLowerCase();
            }

            if (response.equals("no")) {
                playAgain = false;
            }
        }

        // Display final score
        System.out.println("\nGame Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
