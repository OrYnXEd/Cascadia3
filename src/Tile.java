public class Tile {
    private Terrain terrain;
    private WildlifeToken wildlifeToken;
    private boolean isKeystone;
    private int rotation;

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
