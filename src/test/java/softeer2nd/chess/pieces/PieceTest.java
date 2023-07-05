package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;

public class PieceTest {
    @Test
    @DisplayName("기물은 올바른 색상과 표현방법을 가지고 생성되어야 한다")
    public void create_piece() {
        verifyPiece(createWhitePawn(), createBlackPawn(), Type.PAWN);
        verifyPiece(createWhiteKnight(), createBlackKnight(), Type.KNIGHT);
        verifyPiece(createWhiteRook(), createBlackRook(), Type.ROOK);
        verifyPiece(createWhiteBishop(), createBlackBishop(), Type.BISHOP);
        verifyPiece(createWhiteQueen(), createBlackQueen(), Type.QUEEN);
        verifyPiece(createWhiteKing(), createBlackKing(), Type.KING);

        Piece blank = createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Type.PAWN.getBlackRepresentation());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }
}

