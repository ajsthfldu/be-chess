package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;

public class PieceTest {

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Type.PAWN.getBlackRepresentation());
    }
}

