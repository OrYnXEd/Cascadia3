public abstract class ScoringCard {
    private String id;
    private String cardType;

    public ScoringCard(String id, String cardType);
    public String getId();
    public String getCardType();
    public abstract int calculateScore(Board board);
}
