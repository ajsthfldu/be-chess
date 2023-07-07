package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.*;

class PieceFactoryTest {
    @Test
    @DisplayName("기물은 올바른 색상과 표현방법을 가지고 생성되어야 한다")
    public void create_piece() {
        verifyPiece(createWhitePawn(), createBlackPawn(), Piece.Type.PAWN);
        verifyPiece(createWhiteKnight(), createBlackKnight(), Piece.Type.KNIGHT);
        verifyPiece(createWhiteRook(), createBlackRook(), Piece.Type.ROOK);
        verifyPiece(createWhiteBishop(), createBlackBishop(), Piece.Type.BISHOP);
        verifyPiece(createWhiteQueen(), createBlackQueen(), Piece.Type.QUEEN);
        verifyPiece(createWhiteKing(), createBlackKing(), Piece.Type.KING);

        Piece blank = createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Piece.Type.NO_PIECE, blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }
}