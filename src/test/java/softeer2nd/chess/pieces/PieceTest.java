package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.*;

public class PieceTest {
    @Test
    public void create_piece() {
        verifyPiece(createWhitePawn(), WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
        verifyPiece(createBlackPawn(), BLACK_COLOR, BLACK_PAWN_REPRESENTATION);

        verifyPiece(createWhiteKnight(), WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(createBlackKnight(), BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);

        verifyPiece(createWhiteRook(), WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
        verifyPiece(createBlackRook(), BLACK_COLOR, BLACK_ROOK_REPRESENTATION);

        verifyPiece(createWhiteBishop(), WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
        verifyPiece(createBlackBishop(), BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);

        verifyPiece(createWhiteQueen(), WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
        verifyPiece(createBlackQueen(), BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);

        verifyPiece(createWhiteKing(), WHITE_COLOR, WHITE_KING_REPRESENTATION);
        verifyPiece(createBlackKing(), BLACK_COLOR, BLACK_KING_REPRESENTATION);


    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}

