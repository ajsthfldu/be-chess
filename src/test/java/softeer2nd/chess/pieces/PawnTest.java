package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Pawn.*;

public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(WHITE_COLOR, pawn.getColor());
        assertEquals(WHITE_REPRESENTATION, pawn.getRepresentation());
    }

    @Test
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, BLACK_REPRESENTATION);
        verifyPawn(EMPTY_COLOR, EMPTY_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}

