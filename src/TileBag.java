import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileBag {
    private List<Tile> tiles;

    public TileBag() {
        tiles = new ArrayList<>();
        // Add starter habitat tiles
        for (int i = 0; i < 5; i++) {
            tiles.add(new Tile(Terrain.STARTER, true));
        }
        // Add other tiles
        for (Terrain terrain : Terrain.values()) {
            if (terrain != Terrain.STARTER) {
                for (int i = 0; i < 5; i++) {
                    tiles.add(new Tile(terrain, false));
                }
            }
        }
        Collections.shuffle(tiles);
    }

    public Tile drawRandomTile() {
        if (!tiles.isEmpty()) {
            return tiles.remove(tiles.size() - 1);
        }
        return null;
    }
}
