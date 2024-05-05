import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        int lifePoints = 3; // Initialize life points

        while (true) {
            if (lifePoints <= 0) { // Check if life points are zero or less
                System.out.println("Game over! You have run out of life points.");
                break;
            }

            System.out.println("Life Points: " + lifePoints); // Display remaining life points
            System.out.print("Enter your choice (rock, paper, scissors) or 'quit' to end: ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("quit")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', 'scissors', or 'quit'.");
                continue;
            }

            String computerChoice = choices[random.nextInt(choices.length)];

            System.out.println("Computer choice: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
                lifePoints--; // Reduce life points on incorrect guess
            }
        }
        
        scanner.close(); // Close the scanner after the game loop ends
    }
}

