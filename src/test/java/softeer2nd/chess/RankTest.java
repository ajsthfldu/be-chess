package softeer2nd.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RankTest {
    Rank rank;

    @Test
    void create() {
        new Rank("")
        fail();
    }

    @Test
    void getRepresentation() {
        String blankLine = "........";
        rank = new Rank(blankLine);
        assertEquals(rank.getRepresentation(), blankLine);
    }
}
