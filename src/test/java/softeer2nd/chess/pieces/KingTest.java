package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.chess.pieces.PieceFactory.createWhiteKing;

class KingTest {
    ChessGame game;
    @BeforeEach
    void setup() {
        game = new ChessGame(new Board());
    }

    @Test
    void verifyMovePosition() {
        game.initializeEmpty();
        Piece king = createWhiteKing();
        game.move("a1", king);
        assertTrue(king.verifyMovePosition(game, new Position("a1"), new Position("a2")));
    }
}