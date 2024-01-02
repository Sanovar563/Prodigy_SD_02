package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        // Run the guessing game
        playGuessingGame();
    }

    private static void playGuessingGame() {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        // Initialize variables
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");

        Scanner scanner = new Scanner(System.in);

        while (!guessedCorrectly) {
            // Prompt user for a guess
            System.out.print("Enter your guess (between 1 and 100): ");
            int userGuess = scanner.nextInt();

            // Increment attempts
            attempts++;

            // Compare the guess with the secret number
            if (userGuess == secretNumber) {
                guessedCorrectly = true;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        // Display the result
        System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
    }
}
