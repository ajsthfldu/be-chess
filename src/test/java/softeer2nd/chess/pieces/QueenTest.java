package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.createWhiteKing;
import static softeer2nd.chess.pieces.PieceFactory.createWhiteQueen;

class QueenTest {
    ChessGame game;
    @BeforeEach
    void setup() {
        game = new ChessGame(new Board());
    }

    @Test
    void verifyMovePosition() {
        game.initializeEmpty();
        Piece queen = createWhiteQueen();
        game.move("a1", queen);
        game.move("a2", createWhiteKing());
        assertTrue(queen.verifyMovePosition(game, new Position("a1"), new Position("h8")));
    }
}