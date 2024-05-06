import java.util.Scanner;
import java.util.Random;

class Game {
    Scanner scanner;
    Random random;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void start() {
        System.out.println("Starting the game...");
    }

    public void end() {
        scanner.close();
        System.out.println("Game ended. Thanks for playing!");
    }
}

public class RockPaperScissors extends Game {
    String[] choices = {"rock", "paper", "scissors"};
    int lifePoints = 3; 
    int playerGold = 0;
    int bounty = 0;

    public RockPaperScissors() {
        super(); 
    }

    @Override
    public void start() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        super.start(); 
        play(); 
    }

    public void play() {
        while (true) {
            if (lifePoints <= 0) { 
                System.out.println("Game over! You have run out of life points.");
                break;
            }
    
            if (playerGold >= 1500) { 
                System.out.println("Congratulations! You have won the game by accumulating 1500 gold!");
                end(); 
                break;
            }
    
            System.out.println("Life Points: " + lifePoints); 
            System.out.println("Player's Gold: " + playerGold); 
            System.out.print("Enter your choice (rock, paper, scissors) or 'quit' to end: ");
            String playerChoice = scanner.nextLine().toLowerCase();
    
            if (playerChoice.equals("quit")) {
                end(); 
                break;
            }
    
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', 'scissors', or 'quit'.");
                continue;
            }
    
            String computerChoice = choices[random.nextInt(choices.length)];
    
            System.out.println("Computer choice: " + computerChoice);
    
            determineWinner(playerChoice, computerChoice);
        }
    }
        
public void determineWinner(String playerChoice, String computerChoice) {
    if (playerChoice.equals(computerChoice)) {
        System.out.println("It's a tie!");
    } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
            (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
        System.out.println("You win!");
        int goldReward = random.nextInt(1000) + 1;
        System.out.println("You earned " + goldReward + " gold!");
        playerGold += goldReward;
    } else {
        System.out.println("You lose!");
        if (playerGold > 0) {
            System.out.println("You lost all your gold!");
            playerGold = 0;
        }
        int bountyAmount = random.nextInt(1000) + 1;
        System.out.println("A bounty of " + bountyAmount + " gold is placed on you!");
        bounty += bountyAmount;
        lifePoints--; 
    }
}


    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.start(); 
    }
}



