package softeer2nd.chess;

import org.junit.jupiter.api.Test;
import softeer2nd.chess.exceptions.InvalidPositionException;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.PieceFactory.*;

public class RankTest {

    @Test
    void getRepresentation() {
        Rank rank;
        rank = new Rank("........");
        assertEquals("........", rank.getRepresentation());
        rank = new Rank("P.QkbnNR");
        assertEquals("P.QkbnNR", rank.getRepresentation());
    }

    @Test
    void findPiece() throws InvalidPositionException {
        Rank rank = new Rank("P.QkbnNR");
        assertEquals(createBlackPawn(), rank.findPiece(Position.of("a5")));
        assertEquals(createBlank(), rank.findPiece(Position.of("b4")));
        assertEquals(createBlackQueen(), rank.findPiece(Position.of("c3")));
        assertEquals(createWhiteKing(), rank.findPiece(Position.of("d5")));
        assertEquals(createWhiteBishop(), rank.findPiece(Position.of("e7")));
    }

    @Test
    void updatePiece() throws InvalidPositionException {
        Rank rank = new Rank("P.QkbnNR");
        rank.updatePiece(Position.of("a1"), createBlank());
        assertEquals(rank.getRepresentation(), "..QkbnNR");
        rank.updatePiece(Position.of("d1"), createBlackPawn());
        assertEquals(rank.getRepresentation(), "..QPbnNR");
    }

    @Test
    void getPoint() {
        Rank rank = new Rank("P.QkbnNR");
        assertEquals(5.5, rank.getPoint(Piece.Color.WHITE));
        assertEquals(17.5, rank.getPoint(Piece.Color.BLACK));
    }
}
