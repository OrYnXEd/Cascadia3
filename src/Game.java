import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private int currentPlayerIndex;

    public Game() {
        players = new ArrayList<>();
        board = new Board();
        currentPlayerIndex = 0;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    public void run() {
        int numberOfPlayers = promptNumberOfPlayers();
        List<String> playerNames = promptPlayerNames(numberOfPlayers);
        initializePlayers(playerNames);
        Collections.shuffle(players);

        while (true) {
            displayCurrentPlayerHabitat();
            String command = promptCommand();

            if (command.equalsIgnoreCase("next")) {
                nextPlayer();
            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Game ended.");
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    public int promptNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers;

        while (true) {
            System.out.print("Enter the number of players (2-4): ");
            try {
                numberOfPlayers = Integer.parseInt(scanner.nextLine());
                if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
                    break;
                } else {
                    System.out.println("Invalid input. Number of players must be between 2 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return numberOfPlayers;
    }

    public List<String> promptPlayerNames(int numberOfPlayers) {
        Scanner scanner = new Scanner(System.in);
        List<String> playerNames = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            playerNames.add(playerName);
        }

        return playerNames;
    }

    public void initializePlayers(List<String> playerNames) {
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public void displayCurrentPlayerHabitat() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("Current player: " + currentPlayer.getName());
        System.out.println("Habitat:");
        // Display the habitat of the current player
        board.displayPlayerHabitat(currentPlayer);
    }

    public String promptCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command (next or quit): ");
        return scanner.nextLine();
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
