import java.util.Random;
import java.util.Scanner;

class GameSession {
    private int secretNumber;
    private int maxNumber;
    private int maxAttempts;
    private int attempts;
    private boolean won;

    GameSession(int maxNumber, int maxAttempts) {
        this.maxNumber = maxNumber;
        this.maxAttempts = maxAttempts;
        this.secretNumber = new Random().nextInt(maxNumber) + 1;
        this.attempts = 0;
        this.won = false;
    }

    void play(Scanner scanner) {
        System.out.println("\nI have selected a number between 1 and " + maxNumber);
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("\nEnter your guess: ");

            try {
                int guess = Integer.parseInt(scanner.nextLine());
                attempts++;

                if (guess == secretNumber) {
                    won = true;
                    System.out.println(">> Correct Guess!");
                    System.out.println("-- Attempts Used: " + attempts);
                    System.out.println("-- Score: " + calculateScore() + "/100");
                    return;
                } else if (guess < secretNumber) {
                    System.out.println("-- Too Low!");
                } else {
                    System.out.println("-- Too High!");
                }

                showHint();
                System.out.println("-- Attempts Left: " + (maxAttempts - attempts));

            } catch (NumberFormatException e) {
                System.out.println("!! Invalid input. Please enter numbers only.");
            }
        }

        System.out.println("\n!! Game Over!");
        System.out.println("-- The correct number was: " + secretNumber);
    }

    private void showHint() {
        if (attempts == 3) {
            if (secretNumber % 2 == 0) {
                System.out.println("Hint: The number is even.");
            } else {
                System.out.println("Hint: The number is odd.");
            }
        }
    }

    int calculateScore() {
        return Math.max(100 - (attempts * 10), 10);
    }

    boolean isWon() {
        return won;
    }

    int getAttempts() {
        return attempts;
    }
}

public class NumberGuessingGame {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int totalGames = 0;
        int totalWins = 0;
        int totalAttempts = 0;
        int bestAttempts = Integer.MAX_VALUE;

        System.out.println("======================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("======================================");

        boolean playAgain;

        do {
            int[] settings = selectDifficulty();
            int maxNumber = settings[0];
            int maxAttempts = settings[1];

            GameSession session = new GameSession(maxNumber, maxAttempts);
            session.play(scanner);

            totalGames++;

            if (session.isWon()) {
                totalWins++;
                totalAttempts += session.getAttempts();

                if (session.getAttempts() < bestAttempts) {
                    bestAttempts = session.getAttempts();
                    System.out.println(">> New Best Score!");
                }
            }

            playAgain = askPlayAgain();

        } while (playAgain);

        showFinalStatistics(totalGames, totalWins, totalAttempts, bestAttempts);

        System.out.println("\nThank you for playing Number Guessing Game!");
        scanner.close();
    }

    static int[] selectDifficulty() {
        System.out.println("\nSelect Difficulty Level:");
        System.out.println("1. Easy   (1 - 50, 10 attempts)");
        System.out.println("2. Medium (1 - 100, 8 attempts)");
        System.out.println("3. Hard   (1 - 500, 6 attempts)");

        while (true) {
            System.out.print("\nEnter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        return new int[]{50, 10};
                    case 2:
                        return new int[]{100, 8};
                    case 3:
                        return new int[]{500, 6};
                    default:
                        System.out.println("!! Invalid choice. Please select 1, 2, or 3.");
                }

            } catch (NumberFormatException e) {
                System.out.println("!! Invalid input. Please enter numbers only.");
            }
        }
    }

    static boolean askPlayAgain() {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String choice = scanner.nextLine();

        return choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y");
    }

    static void showFinalStatistics(int games, int wins, int attempts, int bestAttempts) {
        System.out.println("\n======================================");
        System.out.println("             GAME REPORT");
        System.out.println("======================================");

        System.out.println("Total Games Played : " + games);
        System.out.println("Total Wins         : " + wins);
        System.out.println("Total Losses       : " + (games - wins));

        if (wins > 0) {
            double winRate = (wins * 100.0) / games;
            double avgAttempts = (double) attempts / wins;

            System.out.printf("Win Rate           : %.2f%%\n", winRate);
            System.out.printf("Average Attempts   : %.2f\n", avgAttempts);
            System.out.println("Best Score         : " + bestAttempts + " attempts");
        } else {
            System.out.println("Win Rate           : 0.00%");
            System.out.println("Best Score         : No wins yet");
        }

        System.out.println("======================================");
    }
}

