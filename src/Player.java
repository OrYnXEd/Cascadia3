public class Player {
    private String name;
    private Board playerBoard;
    private int natureTokens;
    private Environment environment;

    public Player(String name) {
        this.name = name;
        this.playerBoard = new Board();
        this.natureTokens = 0;
        this.environment = new Environment();
    }

    public String getName() {
        return name;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public int getNatureTokens() {
        return natureTokens;
    }

    public void addNatureToken() {
        this.natureTokens++;
    }
    public void placeTileAndToken(Tile tile, WildlifeToken token) {
        playerBoard.placeTileAndToken(tile, token);
    }
    public void spendNatureToken() {
        if (natureTokens > 0) {
            this.natureTokens--;
        }
    }

    public Environment getEnvironment() {
        return environment;
    }
}
