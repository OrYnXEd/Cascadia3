import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WildlifeTokenBag {
    private List<WildlifeToken> tokens;

    public WildlifeTokenBag() {
        tokens = new ArrayList<>();
        // Add code here to populate the tokens list based on game rules
    }

    public WildlifeToken drawRandomToken() {
        if (tokens.isEmpty()) {
            return null;
        }
        Collections.shuffle(tokens);
        return tokens.remove(0);
    }
}
