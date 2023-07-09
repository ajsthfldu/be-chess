package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.createWhiteKing;
import static softeer2nd.chess.pieces.PieceFactory.createWhitePawn;

class PawnTest {

    ChessGame game;
    @BeforeEach
    void setup() {
        game = new ChessGame(new Board());
    }

    @Test
    void verifyMovePosition() {
        game.initializeEmpty();
        Piece pawn = createWhitePawn();
        game.move("a1", pawn);
        assertTrue(pawn.verifyMovePosition(game.getBoard(), new Position("a1"), new Position("a2")));
    }

}