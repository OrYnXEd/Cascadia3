public enum Wildlife {
    HAWK("H", "Blue"),
    BEAR("B", "Brown"),
    ELK("E", "Black"),
    SALMON("S", "Pink/Red"),
    FOX("F", "Orange");

    private final String displayChar;
    private final String color;

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

    public String getAbbreviation() {
        return String.valueOf(displayChar);
    }
}
