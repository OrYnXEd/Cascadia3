public enum Terrain {
    FOREST('F'),
    WETLAND('W'),
    RIVER('R'),
    MOUNTAIN('M'),
    PRAIRIE('P');

    private final char displayChar;

    Terrain(char displayChar) {
        this.displayChar = displayChar;
    }

    public char getDisplayChar() {
        return displayChar;
    }
}
