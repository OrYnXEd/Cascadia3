import java.util.List;

public class Tile {
    private Terrain terrain;
    private WildlifeToken wildlifeToken;
    private boolean isKeystone;
    private int rotation;
    private boolean isStarter;

    public Tile(Terrain terrain, boolean isStarter) {
        this.terrain = terrain;
        this.isStarter = isStarter;
    }

    public Tile(Terrain terrain, WildlifeToken wildlifeToken, boolean isKeystone) {
        this.terrain = terrain;
        this.wildlifeToken = wildlifeToken;
        this.isKeystone = isKeystone;
        this.rotation = 0;
    }

    public boolean isStarter() {
        return isStarter;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public WildlifeToken getWildlifeToken() {
        return wildlifeToken;
    }

    public boolean canPlaceTile(Tile newTile, int row, int col) {
        // Implement logic to check if the newTile can be placed at (row, col) according to the rules
        return true; // change this
    }

    public List<Terrain> getTerrains() {
        return List.of(terrain);
    }

    public List<Wildlife> getWildlife() {
        return wildlifeToken != null ? List.of(wildlifeToken.getWildlife()) : List.of();
    }

    public String getDescription() {
        return "This tile has " + getTerrains() + ". You can place " + getWildlife() + " on this tile.";
    }

    public boolean canPlaceToken(WildlifeToken token, int row, int col) {
        // Implement logic to check if the token can be placed at (row, col) according to the rules
        return true; // change this
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
