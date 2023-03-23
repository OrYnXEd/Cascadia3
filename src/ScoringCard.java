public abstract class ScoringCard {
    private String id;
    private String cardType;

    public ScoringCard(String id, String cardType) {
        this.id = id;
        this.cardType = cardType;
    }

    public String getId() {
        return id;
    }

    public String getCardType() {
        return cardType;
    }

    public abstract int calculateScore(Board board);
}
