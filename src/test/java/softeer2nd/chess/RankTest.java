package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RankTest {
    Rank rank;

    @Test
    void create() {
        fail();
    }

    @Test
    void getRepresentation() {
        String blankLine = "........";
        rank = new Rank(blankLine);
        assertEquals(rank.getRepresentation(), blankLine);
    }
}
