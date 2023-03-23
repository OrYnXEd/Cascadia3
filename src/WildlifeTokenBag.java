import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WildlifeTokenBag {
    private List<WildlifeToken> tokens;

    public WildlifeTokenBag() {
        tokens = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tokens.add(new WildlifeToken(Wildlife.BEAR));
            tokens.add(new WildlifeToken(Wildlife.ELK));
            tokens.add(new WildlifeToken(Wildlife.SALMON));
            tokens.add(new WildlifeToken(Wildlife.HAWK));
            tokens.add(new WildlifeToken(Wildlife.FOX));
        }
        Collections.shuffle(tokens);
    }

    public WildlifeToken drawRandomToken() {
        if (!tokens.isEmpty()) {
            return tokens.remove(tokens.size() - 1);
        }
        return null;
    }
}
