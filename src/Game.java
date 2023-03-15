import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean gameEnded;

    public Game() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        gameEnded = false;
    }

    public void promptNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers;
        do {
            System.out.print("Enter the number of players (2-4): ");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers < 2 || numberOfPlayers > 4) {
                System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
            }
        } while (numberOfPlayers < 2 || numberOfPlayers > 4);

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }

        Collections.shuffle(players);
        System.out.println("Random player order:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName());
        }
    }

    public void displayCurrentPlayerHabitat() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println(currentPlayer.getName() + "'s habitat:");
        currentPlayer.getPlayerBoard().displayPlayerHabitat();
    }

    public void handleCommand(String command) {
        if (command.equalsIgnoreCase("next")) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            displayCurrentPlayerHabitat();
        } else if (command.equalsIgnoreCase("quit")) {
            gameEnded = true;
        }
    }

    public void start() {
        promptNumberOfPlayers();
        displayCurrentPlayerHabitat();

        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            System.out.print("Enter a command (next, quit): ");
            String command = scanner.next();
            handleCommand(command);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
