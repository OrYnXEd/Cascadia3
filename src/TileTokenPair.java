public class TileTokenPair {
    private HabitatTile habitatTile;
    private WildlifeToken wildlifeToken;

    public TileTokenPair(HabitatTile habitatTile, WildlifeToken wildlifeToken) {
        this.habitatTile = habitatTile;
        this.wildlifeToken = wildlifeToken;
    }

    public HabitatTile getHabitatTile() {
        return habitatTile;
    }

    public WildlifeToken getWildlifeToken() {
        return wildlifeToken;
    }
}
