import java.util.List;

public class KeystoneTile extends Tile {
    public KeystoneTile(List<Terrain> terrains, List<Wildlife> wildlife) {
        super(terrains, wildlife);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nThis tile is a Keystone Tile. Whenever you place the matching Wildlife Token onto a Keystone Tile, you gain a Nature Token.";
    }
}