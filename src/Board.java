import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> tiles;
    private List<WildlifeToken> tokens;

    public Board() {
        tiles = new ArrayList<>();
        tokens = new ArrayList<>();
    }

    public void placeTile(Tile tile, int index) {
        if (index >= 0 && index < tiles.size()) {
            tiles.add(index, tile);
        } else {
            tiles.add(tile);
        }
    }

    public void rotateTile(int tileIndex, int angle) {
        if (tileIndex >= 0 && tileIndex < tiles.size()) {
            tiles.get(tileIndex).rotate(angle);
        }
    }

    public void placeWildlifeToken(WildlifeToken token, int index) {
        if (index >= 0 && index < tokens.size()) {
            tokens.add(index, token);
        } else {
            tokens.add(token);
        }
    }

    public boolean attemptTokenPlacement(WildlifeToken token, int index) {
        // Add logic to check if the token can be placed at the specified index
        // based on the game rules.
        // If it can be placed, return true, otherwise return false.
        return true;
    }

    public void displayPlayerHabitat() {
        // Display the board with ASCII Art, including habitats and wildlife tokens
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            char tileChar = tile.getDisplayChar();
            System.out.print(tileChar);

            if (i < tokens.size()) {
                WildlifeToken token = tokens.get(i);
                char tokenChar = token.getDisplayChar();
                System.out.print(tokenChar);
            } else {
                System.out.print(" ");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
