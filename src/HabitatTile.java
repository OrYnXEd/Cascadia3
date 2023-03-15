public class HabitatTile {
    private Terrain terrain;
    private int rotation;

    public HabitatTile(Terrain terrain) {
        this.terrain = terrain;
        this.rotation = 0;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public int getRotation() {
        return rotation;
    }

    public void rotate(int angle) {
        this.rotation = (this.rotation + angle) % 360;
    }
}
