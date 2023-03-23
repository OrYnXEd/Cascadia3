import javax.swing.*;
import java.awt.Point;
import java.util.*;

public class Game {
    private List<Player> players;
    private Player currentPlayer;

    private List<WildlifeScoringCard> wildlifeScoringCards;
    private int currentPlayerIndex;
    private boolean gameEnded;
    private TileBag tileBag;
    private WildlifeTokenBag wildlifeTokenBag;
    private List<Tile> availableTiles;
    private List<WildlifeToken> availableTokens;
    private List<WildlifeToken> tokens;
    private List<NatureToken> natureTokens;
    private int totalTurns;
    private int turnCount;

    public Game() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        gameEnded = false;
        tileBag = new TileBag();
        wildlifeTokenBag = new WildlifeTokenBag();
        availableTiles = new ArrayList<>();
        availableTokens = new ArrayList<>();
        wildlifeScoringCards = new ArrayList<>();
        totalTurns = 0;
        natureTokens = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            natureTokens.add(new NatureToken());
        }
        turnCount = 0;
    }



    public void spendNatureToken() {
        // Add logic to spend nature tokens and perform the selected action
    }

    public void displayWildlifeScoringCards() {
        // Randomly select 5 wildlife scoring cards and display them
        List<String> possibleDescriptions = Arrays.asList(
                "Scoring rule 1",
                "Scoring rule 2",
                "Scoring rule 3",
                "Scoring rule 4",
                "Scoring rule 5",
                "Scoring rule 6",
                "Scoring rule 7",
                "Scoring rule 8",
                "Scoring rule 9",
                "Scoring rule 10"
        );

        Collections.shuffle(possibleDescriptions);
        for (int i = 0; i < 5; i++) {
            WildlifeScoringCard card = new WildlifeScoringCard(possibleDescriptions.get(i));
            wildlifeScoringCards.add(card);
            System.out.println("Scoring card " + (i + 1) + ": " + card.getDescription());
        }
    }

    public void calculateAndDisplayScorecard() {
        // Add logic to calculate and display scores for each player
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
            if (tile != null && token != null) {
                availableTiles.add(tile);
                availableTokens.add(token);
                System.out.println("Pair " + (i + 1) + ": " + tile.getTerrain().name() + " - " + token.getWildlife().name());
            } else {
                System.out.println("Error: Tile or token is null.");
            }
        }
    }


    public void displayCurrentPlayerHabitat() {
        System.out.println("Current player: " + players.get(currentPlayerIndex).getName());
        players.get(currentPlayerIndex).getPlayerBoard().displayBoard();
    }
    public void wipeOverpopulatedTokens() {
        // Wipe overpopulated tokens and replace them with new tokens
    }
    public void selectTileAndTokenCombination() {
        wipeOverpopulatedTokens();

        boolean spentNatureToken = false;
        if (currentPlayer.getNatureTokens() > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to spend a nature token? (yes/no): ");
            String answer = scanner.next();
            spentNatureToken = "yes".equalsIgnoreCase(answer);

            if (spentNatureToken) {
                spendNatureToken();
            }
        }

        if (!spentNatureToken) {
            // Select an existing combination
        }
    }

    public void placeTileAndToken(Tile tile, WildlifeToken token) {
        currentPlayer.getPlayerBoard().placeTile(tile);
        currentPlayer.getPlayerBoard().placeWildlifeToken(token);
    }
    public void playTurn(int pairIndex) {
        if (pairIndex >= 0 && pairIndex < availableTiles.size()) {
            Tile selectedTile = availableTiles.get(pairIndex);
            WildlifeToken selectedToken = availableTokens.get(pairIndex);
            Player currentPlayer = players.get(currentPlayerIndex);
            // Add the selected tile and token to the player's environment
            currentPlayer.getPlayerBoard().addTile(selectedTile);
            currentPlayer.getPlayerBoard().placeWildlifeToken(selectedToken, -1);

            // Replace the selected tile and token
            availableTiles.set(pairIndex, tileBag.drawRandomTile());
            availableTokens.set(pairIndex, wildlifeTokenBag.drawRandomToken());

            // Increment the total turns played
            totalTurns++;
            if (totalTurns == 20 * players.size()) {
                gameEnded = true;
            }
            selectTileAndTokenCombination();

            placeTileAndToken(selectedTile, selectedToken);

        }

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


    public void selectTileAndToken() {
        // ... (Existing method code)

        // Prompt the player to make a selection
        // (e.g., ask for tile and token indices)
        int selectedTileIndex = 0; // Get the selected tile index from the user input
        int selectedTokenIndex = 0; // Get the selected token index from the user input

        // Retrieve the selected tile and token
        Tile selectedTile = availableTiles.get(selectedTileIndex);
        WildlifeToken selectedToken = availableTokens.get(selectedTokenIndex);

        // Remove the selected tile and token from the available ones
        availableTiles.remove(selectedTileIndex);
        availableTokens.remove(selectedTokenIndex);

        // Place the selected tile and token in the player's environment
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.placeTileAndToken(selectedTile, selectedToken);

        // Replace the taken tile and token with new ones
        Tile newTile = tileBag.drawRandomTile();
        WildlifeToken newToken = wildlifeTokenBag.drawRandomToken();
        availableTiles.add(selectedTileIndex, newTile);
        availableTokens.add(selectedTokenIndex, newToken);
    }

    public void placeWildlifeToken(WildlifeToken token, int index) {
        if (index >= 0 && index < tokens.size()) {
            tokens.add(index, token);
        } else {
            tokens.add(token);
        }
    }


    public void skipTokenPlacement() {
        System.out.println("Skipping token placement.");
    }

    public void giveNatureToken() {
        currentPlayer.addNatureToken();
    }

    public void replaceVisiblePairs() {
        // Replace the selected tile and token in the 4 visible pairs
    }

    public void playTurns() {
        // Implement the logic for players taking turns
    }

    public void checkForEndOfGame() {
        // Check if no more tiles are available and end the game
    }
    public boolean isGameOver() {
        // Check if there are no face-down Habitat Tiles left
        return habitatTileStacks.isEmpty();
    }

    public int calculateWildlifeScoring(Player player) {
        // Implement the scoring logic for Wildlife Scoring Cards
    }

    public int calculateHabitatTileCorridors(Player player) {
        // Implement the scoring logic for Habitat Tile Corridors
    }

    public int calculateHabitatTileCorridorMajorities(Player player) {
        // Implement the scoring logic for Habitat Tile Corridor Majorities
    }

    public int calculateNatureTokenScore(Player player) {
        return player.getNatureTokenScore();
    }

    public int calculateTotalScore(Player player) {
        int totalScore = calculateWildlifeScoring(player) +
                calculateHabitatTileCorridors(player) +
                calculateHabitatTileCorridorMajorities(player) +
                calculateNatureTokenScore(player);

        return totalScore;
    }

    public void endGame() {
        // Calculate scores for each player
        for (Player player : players) {
            int totalScore = calculateTotalScore(player);
            System.out.println("Player " + player.getId() + " total score: " + totalScore);
        }

        // Determine the winner and handle tiebreakers
    }
    public class ScoringCard {

        public enum WildlifeType {
            BEAR,
            ELK,
            SALMON,
            HAWK,
            FOX
        }

        public enum ScoringType {
            A,
            B,
            C,
            D
        }

        private WildlifeType wildlifeType;
        private ScoringType scoringType;

        public ScoringCard(WildlifeType wildlifeType, ScoringType scoringType) {
            this.wildlifeType = wildlifeType;
            this.scoringType = scoringType;
        }

        public WildlifeType getWildlifeType() {
            return wildlifeType;
        }

        public ScoringType getScoringType() {
            return scoringType;
        }
    }




    public void start() {
        promptNumberOfPlayers();
        selectStarterHabitatTiles();
        drawAndDisplayTileTokenPairs();
        displayWildlifeScoringCards();
                displayCurrentPlayerHabitat();
        playTurn(5);
        calculateAndDisplayScorecard();

        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            System.out.print("Enter a command (next, quit): ");
            String command = scanner.next();
            handleCommand(command);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board(10, 10); // Adjust the size as needed
        // Initialize the board with tiles and tokens

        BoardGUI boardGUI = new BoardGUI(board);

        JFrame frame = new JFrame("Cascadia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(boardGUI);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }

    }

