public enum Wildlife {
    HAWK("H", "Blue"),
    BEAR("B", "Brown"),
    ELK("E", "Black"),
    SALMON("S", "Pink/Red"),
    FOX("F", "Orange");

    private String displayChar;
    private String color;

    Wildlife(String displayChar, String color) {
        this.displayChar = displayChar;
        this.color = color;
    }

    public String getDisplayChar() {
        return displayChar;
    }

    public String getColor() {
        return color;
    }
}
