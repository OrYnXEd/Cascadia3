import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;


public class Board {
    private Tile[][] grid;
    private int size;
    private List<Tile> tiles;
    private List<WildlifeToken> tokens;

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;





    public Board() {
        size = 8;
        grid = new Tile[size][size];
        tiles = new ArrayList<>();
        tokens = new ArrayList<>();
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void placeTile(Tile tile, int row, int col) {
        grid[row][col] = tile;
    }



    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public boolean isValidPlacement(Tile tile, int row, int col) {
        if (grid[row][col] != null) {
            return false;
        }

        int adjacentCount = 0;
        if (row > 0 && grid[row - 1][col] != null) {
            adjacentCount++;
        }
        if (row < size - 1 && grid[row + 1][col] != null) {
            adjacentCount++;
        }
        if (col > 0 && grid[row][col - 1] != null) {
            adjacentCount++;
        }
        if (col < size - 1 && grid[row][col + 1] != null) {
            adjacentCount++;
        }

        return adjacentCount > 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].getDisplayChar());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }


    public void displayBoard() {
        AnsiConsole.systemInstall(); // Enable Jansi

        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            WildlifeToken token = null;

            if (i < tokens.size()) {
                token = tokens.get(i);
            }

            if (tile != null) {
                // Display tile
                Ansi.Color bgColor = getAnsiColorForTerrain(tile.getTerrain());
                Ansi ansiTile = Ansi.ansi().bg(bgColor).a(tile.getTerrain().getAbbreviation()).reset();
                System.out.print(ansiTile);
            } else {
                System.out.print(" ");
            }

            // Display token if present
            if (token != null) {
                Ansi.Color fgColor = getAnsiColorForWildlife(token.getWildlife());
                Ansi ansiToken = Ansi.ansi().bg(fgColor).fg(Ansi.Color.BLACK).a(token.getWildlife().getAbbreviation()).reset();
                System.out.print(ansiToken);
            } else {
                System.out.print(" ");
            }

            System.out.print(" ");
        }

        System.out.println();
        AnsiConsole.systemUninstall(); // Disable Jansi
    }

    private Ansi.Color getAnsiColorForTerrain(Terrain terrain) {
        switch (terrain) {
            case FOREST:
                return Ansi.Color.GREEN;
            case WETLAND:
                return Ansi.Color.CYAN;
            case RIVER:
                return Ansi.Color.BLUE;
            case MOUNTAIN:
                return Ansi.Color.WHITE;
            case PRAIRIE:
                return Ansi.Color.YELLOW;
            default:
                return Ansi.Color.DEFAULT;
        }
    }

    private Ansi.Color getAnsiColorForWildlife(Wildlife wildlife) {
        switch (wildlife) {
            case HAWK:
                return Ansi.Color.BLUE;
            case BEAR:
                return Ansi.Color.YELLOW;
            case ELK:
                return Ansi.Color.BLACK;
            case SALMON:
                return Ansi.Color.RED;
            case FOX:
                return Ansi.Color.MAGENTA;
            default:
                return Ansi.Color.DEFAULT;
        }
    }

    public void placeTile(Tile tile, int index) {
        if (index >= 0 && index < tiles.size()) {
            tiles.add(index, tile);
        } else {
            tiles.add(tile);
        }
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }



    public void rotateTile(int tileIndex, int angle) {
        if (tileIndex >= 0 && tileIndex < tiles.size()) {
            tiles.get(tileIndex).rotate(angle);
        }
    }
    public void placeTileAndToken(Tile tile, WildlifeToken token) {
        // Add code here to place the tile and token in the board
        // according to the game rules and placement logic.
    }

    public void placeWildlifeToken(WildlifeToken token, int index) {
        if (index >= 0 && index < tokens.size()) {
            tokens.add(index, token);
        } else {
            tokens.add(token);
        }
    }

    public boolean attemptTokenPlacement(WildlifeToken token, Point position) {
        // Add logic to check if the token can be placed at the specified position
        // based on the game rules.
        // If it can be placed, return true, otherwise return false.
        return true;
    }

    public void displayPlayerHabitat() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            char tileChar = tile.getDisplayChar();
            System.out.print(tileChar);

            if (i < tokens.size()) {
                Wildlife token = tokens.get(i).getWildlife();
                String tokenChar = token.getDisplayChar();
                System.out.print(tokenChar);
            } else {
                System.out.print(" ");
            }
            System.out.print(" ");
        }
        System.out.println();
    }


    public boolean canPlaceWildlifeToken(WildlifeToken token, Point position) {
        // Add logic to check if the token can be placed at the specified position
        // based on the game rules.
        // If it can be placed, return true, otherwise return false.
        return true;
    }
    public boolean canPlaceTile(Tile tile, Point position) {
        // Check if the tile can be placed at the given position according to the placement rules
    }

    public void placeTile(Tile tile, Point position) {
        // Place the tile in the environment according to the placement rules
    }

   // public boolean canPlaceWildlifeToken(WildlifeToken token, Point position) {
        // Check if the wildlife token can be placed at the given position according to the placement rules
   // }

    public void placeWildlifeToken(WildlifeToken token, Point position) {
        // Place the wildlife token in the environment according to the placement rules
        if (isKeystoneTile(position)) {
            currentPlayer.addNatureToken();
        }
    }

    public boolean isKeystoneTile(Point position) {
        // Check if the tile at the given position is a Keystone Tile
    }




}
