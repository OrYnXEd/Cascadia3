import java.util.ArrayList;
import java.util.List;

public class Environment {
    private List<Tile> tiles;
    private List<WildlifeToken> tokens;

    public Environment() {
        tiles = new ArrayList<>();
        tokens = new ArrayList<>();
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public void addWildlifeToken(WildlifeToken token) {
        tokens.add(token);
    }
}
