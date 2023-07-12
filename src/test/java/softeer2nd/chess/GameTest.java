package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.*;

class GameTest {
    Game game;
    @BeforeEach
    void setUp() {
        game = new Game(new Board());
        game.initialize();
    }

    @Test
    @DisplayName("기물의 점수를 기준으로 정렬할 수 있어야 한다.")
    void sort() {
        List<Piece> whitePieces = List.of(createWhiteQueen(), createWhiteRook(), createWhiteRook(), createWhiteBishop(), createWhiteBishop(),
                createWhiteKnight(), createWhiteKnight(),
                createWhitePawn(), createWhitePawn(), createWhitePawn(), createWhitePawn(),
                createWhitePawn(), createWhitePawn(), createWhitePawn(), createWhitePawn(),
                createWhiteKing());
        List<Piece> blackPieces = List.of(createBlackQueen(), createBlackRook(), createBlackRook(), createBlackBishop(), createBlackBishop(),
                createBlackKnight(), createBlackKnight(),
                createBlackPawn(), createBlackPawn(), createBlackPawn(), createBlackPawn(),
                createBlackPawn(), createBlackPawn(), createBlackPawn(), createBlackPawn(),
                createBlackKing());
        assertEquals(game.getSortedWhitePieces(false), whitePieces);
        assertEquals(game.getSortedBlackPieces(false), blackPieces);
    }
}