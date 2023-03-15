public class Player {
    private String name;
    private Board playerBoard;
    private int natureTokens;

    public Player(String name) {
        this.name = name;
        this.playerBoard = new Board();
        this.natureTokens = 0;
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

    public void spendNatureToken() {
        if (natureTokens > 0) {
            this.natureTokens--;
        }
    }
}
