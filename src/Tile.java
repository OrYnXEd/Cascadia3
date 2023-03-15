public class Tile {
    private Terrain terrain;
    private WildlifeToken wildlifeToken;
    private boolean isKeystone;

    public Tile(Terrain terrain, WildlifeToken wildlifeToken, boolean isKeystone) {
        this.terrain = terrain;
        this.wildlifeToken = wildlifeToken;
        this.isKeystone = isKeystone;
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
}
