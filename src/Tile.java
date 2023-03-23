import java.util.List;

public class Tile {
    private Terrain terrain;
    private WildlifeToken wildlifeToken;
    private boolean isKeystone;
    private int rotation;
    private boolean isStarter;

    public Tile(Terrain terrain, boolean isStarter, List<Terrain> terrains, List<Wildlife> wildlife) {
        this.terrain = terrain;
        this.isStarter = isStarter;
    }

    public boolean isStarter() {
        return isStarter;
    }

    public Tile(Terrain terrain, WildlifeToken wildlifeToken, boolean isKeystone) {
        this.terrain = terrain;
        this.wildlifeToken = wildlifeToken;
        this.isKeystone = isKeystone;
        this.rotation = 0;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public WildlifeToken getWildlifeToken() {
        return wildlifeToken;
    }
    public void canPlaceTile(Tile newTile, int row, int col) {
        // Implement logic to check if the newTile can be placed at (row, col) according to the rules
    }
    public List<Terrain> getTerrains() {
        return terrain;
    }

    public List<Wildlife> getWildlife() {
        return wildlife;
    }

    public String getDescription() {
        return "This tile has " + terrains + ". You can place " + wildlife + " on this tile.";
    }

    public void canPlaceToken(WildlifeToken token, int row, int col) {
        // Implement logic to check if the token can be placed at (row, col) according to the rules
    }
    public boolean isKeystone() {
        return isKeystone;
    }

    public void rotate(int angle) {
        rotation = (rotation + angle) % 360;
    }

    public char getDisplayChar() {
        return terrain.getDisplayChar();
    }
}
