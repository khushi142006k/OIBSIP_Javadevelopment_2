import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 10;
            boolean guessed = false;

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + attempts + " attempts.");

            for (int i = 1; i <= attempts; i++) {

                System.out.print("Attempt " + i + ": ");
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");

                    int score = (attempts - i + 1) * 10;
                    totalScore += score;

                    System.out.println("Score in this round: " + score);
                    guessed = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too Low! Try Again.");
                } else {
                    System.out.println("Too High! Try Again.");
                }
            }

            if (!guessed) {
                System.out.println("You Lost!");
                System.out.println("Correct Number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}