public class Player {
    // ...
    private String name;
    private Board board;
    private int natureTokens;

   /* public Player(String name) {
        // ...
        this.natureTokens = 0;
    }*/




    public Player(String name) {
        this.name = name;
        this.board = new Board();
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    // ...

    public int getNatureTokens() {
        return natureTokens;
    }

    public void incrementNatureTokens() {
        this.natureTokens++;
    }

    public void spendNatureToken() {
        if (natureTokens > 0) {
            natureTokens--;
        }
    }
}
