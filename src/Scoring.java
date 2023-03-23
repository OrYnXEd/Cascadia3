import java.awt.*;
import java.util.List;
import java.util.Map;

public class Scoring {

    public enum HabitatType {
        MOUNTAINS,
        FORESTS,
        PRAIRIES,
        WETLANDS,
        RIVERS
    }

    public enum WildlifeType {
        BEARS,
        SALMON,
        ELK,
        HAWKS,
        FOXES
    }

    public enum ScoringCard {
        A,
        B,
        C,
        D
    }
    private WildlifeType wildlifeType;
  //  private ScoringType scoringType;
    // Scoring methods for each wildlife type
    public int scoreBears(WildlifeType wildlifeType, ScoringCard scoringCard, Board board) {
        // Implement scoring logic for bears based on the scoringCard
        return 0;
    }
    private int scoreBears(Player player, ScoringCard card) {
        int score = 0;
        // Assuming you have a method to get the bear groups
        List<List<WildlifeToken>> bearGroups = player.getBearGroups();

        switch (card.type) {
            case 'A':
                int pairs = 0;
                for (List<WildlifeToken> group : bearGroups) {
                    if (group.size() == 2) {
                        pairs++;
                    }
                }
                score = pairs * (pairs + 1) / 2; // Increasing number of points
                break;
            case 'B':
                for (List<WildlifeToken> group : bearGroups) {
                    if (group.size() == 3) {
                        score += 10;
                    }
                }
                break;
            case 'C':
                int[] groupSizes = new int[4];
                for (List<WildlifeToken> group : bearGroups) {
                    if (group.size() >= 1 && group.size() <= 3) {
                        groupSizes[group.size()]++;
                    }
                }
                score = groupSizes[1] + groupSizes[2] * 2 + groupSizes[3] * 3;
                if (groupSizes[1] > 0 && groupSizes[2] > 0 && groupSizes[3] > 0) {
                    score += 3; // Bonus for having one of each group size
                }
                break;
            case 'D':
                for (List<WildlifeToken> group : bearGroups) {
                    if (group.size() >= 2 && group.size() <= 4) {
                        score += group.size();
                    }
                }
                break;
        }

        return score;
    }





    public int scoreSalmon(WildlifeType wildlifeType, ScoringCard scoringCard, Board board) {
        // Implement scoring logic for salmon based on the scoringCard
        return 0;
    }
      private int scoreSalmon(Player player, ScoringCard card) {
        int score = 0;
        // Assuming you have a method to get the salmon runs
        List<List<WildlifeToken>> salmonRuns = player.getSalmonRuns();

        for (List<WildlifeToken> run : salmonRuns) {
            int runSize = run.size();
            switch (card.type) {
                case 'A':
                    if (runSize <= 7) {
                        score += runSize;
                    }
                    break;
                case 'B':
                    if (runSize <= 5) {
                        score += runSize;
                    }
                    break;
                case 'C':
                    if (runSize >= 3 && runSize <= 5) {
                        score += runSize;
                    }
                    break;
                case 'D':
                    score += runSize + countAdjacentAnimals(run);
                    break;
            }
        }

        return score;
    }

    // Helper method to count adjacent animal tokens
    private int countAdjacentAnimals(List<WildlifeToken> run) {
        int count = 0;
        // Logic to count adjacent animal tokens
        return count;
    }






    public int scoreElk(WildlifeType wildlifeType, ScoringCard scoringCard, Board board) {
        // Implement scoring logic for elk based on the scoringCard
        return 0;
    }
    private int scoreElk(Player player, ScoringCard card) {
        int score = 0;
        // Assuming you have a method to get the elk groups
        List<List<WildlifeToken>> elkGroups = player.getElkGroups();

        switch (card.type) {
            case 'A':
                for (List<WildlifeToken> group : elkGroups) {
                    if (isStraightLine(group)) {
                        score += group.size();
                    }
                }
                break;
            case 'B':
                for (List<WildlifeToken> group : elkGroups) {
                    if (isExactShape(group, card.shape)) {
                        score += card.points;
                    }
                }
                break;
            case 'C':
                for (List<WildlifeToken> group : elkGroups) {
                    score += (group.size() * (group.size() + 1)) / 2;
                }
                break;
            case 'D':
                for (List<WildlifeToken> group : elkGroups) {
                    if (isCircularFormation(group)) {
                        score += group.size();
                    }
                }
                break;
        }

        return score;
    }

    // Helper methods to check the shapes and formations of elk groups
    private boolean isStraightLine(List<WildlifeToken> group) {
        // Logic to check if the group is a straight line
    }

    private boolean isExactShape(List<WildlifeToken> group, Shape shape) {
        // Logic to check if the group matches the exact shape provided
    }

    private boolean isCircularFormation(List<WildlifeToken> group) {
        // Logic to check if the group is in a circular formation
    }




    public int scoreHawks(WildlifeType wildlifeType, ScoringCard scoringCard, Board board) {
        // Implement scoring logic for hawks based on the scoringCard
        return 0;
    }
    private int scoreHawks(Player player, ScoringCard card) {
        int score = 0;
        List<WildlifeToken> hawks = player.getWildlifeTokensByType(WildlifeType.HAWK);

        switch (card.type) {
            case 'A':
                score += calculateHawkNonAdjacentPoints(hawks);
                break;
            case 'B':
                score += calculateHawkNonAdjacentLineOfSightPoints(hawks);
                break;
            case 'C':
                score += calculateHawkLineOfSightPoints(hawks);
                break;
            case 'D':
                score += calculateHawkPairUniqueAnimalPoints(hawks);
                break;
        }

        return score;
    }

    // Helper methods to calculate scoring based on card type
    private int calculateHawkNonAdjacentPoints(List<WildlifeToken> hawks) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }

    private int calculateHawkNonAdjacentLineOfSightPoints(List<WildlifeToken> hawks) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }

    private int calculateHawkLineOfSightPoints(List<WildlifeToken> hawks) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }

    private int calculateHawkPairUniqueAnimalPoints(List<WildlifeToken> hawks) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }







    public int scoreFoxes(WildlifeType wildlifeType, ScoringCard scoringCard, Board board) {
        // Implement scoring logic for foxes based on the scoringCard
        return 0;
    }
    private int scoreFoxes(Player player, ScoringCard card) {
        int score = 0;
        List<WildlifeToken> foxes = player.getWildlifeTokensByType(WildlifeType.FOX);

        switch (card.type) {
            case 'A':
                score += calculateFoxUniqueAdjacentAnimalsPoints(foxes);
                break;
            case 'B':
                score += calculateFoxUniqueAdjacentAnimalPairsPoints(foxes);
                break;
            case 'C':
                score += calculateFoxMostAbundantAdjacentAnimalPoints(foxes);
                break;
            case 'D':
                score += calculateFoxPairUniqueAdjacentAnimalPairsPoints(foxes);
                break;
        }

        return score;
    }

    // Helper methods to calculate scoring based on card type
    private int calculateFoxUniqueAdjacentAnimalsPoints(List<WildlifeToken> foxes) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }

    private int calculateFoxUniqueAdjacentAnimalPairsPoints(List<WildlifeToken> foxes) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }

    private int calculateFoxMostAbundantAdjacentAnimalPoints(List<WildlifeToken> foxes) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }

    private int calculateFoxPairUniqueAdjacentAnimalPairsPoints(List<WildlifeToken> foxes) {
        int score = 0;
        // Implement logic to calculate score
        return score;
    }






    public int calculateScore(Player player, Map<WildlifeType, ScoringCard> scoringCards, Board board) {
        int totalScore = 0;

        for (WildlifeType wildlifeType : WildlifeType.values()) {
            ScoringCard scoringCard = scoringCards.get(wildlifeType);
            int score = 0;
            switch (wildlifeType) {
                case BEARS:
                    score = scoreBears(wildlifeType, scoringCard, board);
                    break;
                case SALMON:
                    score = scoreSalmon(wildlifeType, scoringCard, board);
                    break;
                case ELK:
                    score = scoreElk(wildlifeType, scoringCard, board);
                    break;
                case HAWKS:
                    score = scoreHawks(wildlifeType, scoringCard, board);
                    break;
                case FOXES:
                    score = scoreFoxes(wildlifeType, scoringCard, board);
                    break;
            }
            totalScore += score;
        }

        return totalScore;
    }

///




    public void ScoringCard(WildlifeType wildlifeType, ScoringType scoringType) {
        this.wildlifeType = wildlifeType;
        this.scoringType = scoringType;
    }

    public WildlifeType getWildlifeType() {
        return wildlifeType;
    }

    public ScoringType getScoringType() {
        return scoringType;
    }
}



