package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/game")
public class DemoApplicationController {

    private final Random random = new Random();
    private int secretNumber;
    private int attempts;

    @PostMapping("/start")
    public void startGame() {
        secretNumber = random.nextInt(100) + 1;
        attempts = 0;
    }

    @PostMapping("/guess")
    public String makeGuess(@RequestParam int guess) {
        attempts++;
        if (guess == secretNumber) {
            return "Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.";
        } else if (guess < secretNumber) {
            return "Too low! Try again.";
        } else {
            return "Too high! Try again.";
        }
    }
}
