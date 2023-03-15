import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileBag {
    private List<Tile> tiles;

    public TileBag() {
        tiles = new ArrayList<>();
        // Add code here to populate the tiles list based on game rules
    }

    public Tile drawRandomTile() {
        if (tiles.isEmpty()) {
            return null;
        }
        Collections.shuffle(tiles);
        return tiles.remove(0);
    }
}
