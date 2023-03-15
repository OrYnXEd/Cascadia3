import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean gameEnded;
    private TileBag tileBag;
    private WildlifeTokenBag wildlifeTokenBag;
    private List<Tile> availableTiles;
    private List<WildlifeToken> availableTokens;

    public Game() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        gameEnded = false;
        tileBag = new TileBag();
        wildlifeTokenBag = new WildlifeTokenBag();
        availableTiles = new ArrayList<>();
        availableTokens = new ArrayList<>();
    }

    public void promptNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players (2-4): ");
        int numPlayers = scanner.nextInt();
        while (numPlayers < 2 || numPlayers > 4) {
            System.out.print("Invalid input. Enter the number of players (2-4): ");
            numPlayers = scanner.nextInt();
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }

        Collections.shuffle(players);
        System.out.println("The playing order is: ");
        for (int i = 0; i < numPlayers; i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName());
        }
    }

    public void selectStarterHabitatTiles() {
        for (Player player : players) {
            Tile starterTile = tileBag.drawRandomTile();
            player.getPlayerBoard().addTile(starterTile);
        }
    }

    public void drawAndDisplayTileTokenPairs() {
        for (int i = 0; i < 4; i++) {
            Tile tile = tileBag.drawRandomTile();
            WildlifeToken token = wildlifeTokenBag.drawRandomToken();
            availableTiles.add(tile);
            availableTokens.add(token);
            System.out.println("Pair " + (i + 1) + ": " + tile.getTerrain().name() + " - " + token.getWildlife().name());
        }
    }

    public void displayCurrentPlayerHabitat() {
        System.out.println("Current player: " + players.get(currentPlayerIndex).getName());
        players.get(currentPlayerIndex).getPlayerBoard().displayBoard();
    }

    public void handleCommand(String command) {
        if ("next".equalsIgnoreCase(command)) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            displayCurrentPlayerHabitat();
        } else if ("quit".equalsIgnoreCase(command)) {
            gameEnded = true;
        } else {
            System.out.println("Invalid command. Please enter 'next' or 'quit'.");
        }
    }

    public void start() {
        promptNumberOfPlayers();
        selectStarterHabitatTiles();
        drawAndDisplayTileTokenPairs();
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
