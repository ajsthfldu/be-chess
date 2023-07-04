package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.*;

public class PieceTest {
    @Test
    public void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertEquals(WHITE_COLOR, piece.getColor());
        assertEquals(WHITE_PAWN_REPRESENTATION, piece.getRepresentation());
    }

    @Test
    public void create() {
        verifyPiece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
        verifyPiece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
        verifyPiece(EMPTY_COLOR, EMPTY_REPRESENTATION);
    }

    void verifyPiece(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}

