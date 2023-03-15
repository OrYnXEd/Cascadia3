public enum Terrain {
    FOREST('F', "Dark green"),
    WETLAND('W', "Light green"),
    RIVER('R', "Blue"),
    MOUNTAIN('M', "Grey"),
    PRAIRIE('P', "Yellow");

    private final char displayChar;
    private final String color;

    Terrain(char displayChar, String color) {
        this.displayChar = displayChar;
        this.color = color;
    }

    public char getDisplayChar() {
        return displayChar;
    }
}
