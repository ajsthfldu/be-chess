package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class ChessGameTest {
    ChessGame game;

    @BeforeEach
    public void setUp() {
        game = new ChessGame(new Board());
    }


    @Test
    @DisplayName("새로운 기물을 지정한 위치에 놓을 수 있어야 한다")
    public void add() throws Exception {
        game.initializeEmpty();

        String position = "b5";
        Piece piece = createBlackRook();
        game.move(position, piece);

        assertEquals(piece, game.findPiece(position));
    }

    @Test
    @DisplayName("선택한 위치의 기물을 지정한 위치에 놓을 수 있어야 한다")
    public void move() throws Exception {
        game.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.move(sourcePosition, targetPosition);
        assertEquals(createBlank(), game.findPiece(sourcePosition));
        assertEquals(createWhitePawn(), game.findPiece(targetPosition));
    }


    private void addPiece(String position, Piece piece) {
        game.move(position, piece);
    }


    @Test
    @DisplayName("색상별 기물의 점수에 따라 정렬된 리스트를 얻을 수 있어야 한다")
    public void getSortedPieces() {
        game.initializeEmpty();

        addPiece("b6", createBlackPawn());
        addPiece("e6", createBlackQueen());
        addPiece("a7", createBlackPawn());
        addPiece("c7", createBlackPawn());
        addPiece("d7", createBlackBishop());
        addPiece("b8", createBlackKing());
        addPiece("c8", createBlackRook());

        addPiece("f4", createWhiteKnight());
        addPiece("g4", createWhiteQueen());
        addPiece("f3", createWhitePawn());
        addPiece("h2", createWhitePawn());
        addPiece("f2", createWhitePawn());
        addPiece("g2", createWhitePawn());
        addPiece("e1", createWhiteRook());
        addPiece("f1", createWhiteKing());

        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(createBlackQueen());
        blackPieces.add(createBlackRook());
        blackPieces.add(createBlackBishop());
        blackPieces.add(createBlackPawn());
        blackPieces.add(createBlackPawn());
        blackPieces.add(createBlackPawn());
        blackPieces.add(createBlackKing());

        int sizeOfBlack = blackPieces.size();
        List<Piece> blackTestPieces = game.getSortedBlackPieces(false);
        for (int i = 0; i < sizeOfBlack; i++) {
            assertEquals(blackPieces.get(i), blackTestPieces.get(i));
        }
        blackTestPieces = game.getSortedBlackPieces(true);
        for (int i = 0; i < sizeOfBlack; i++) {
            assertEquals(blackPieces.get(sizeOfBlack - i - 1), blackTestPieces.get(i));
        }

        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(createWhiteQueen());
        whitePieces.add(createWhiteRook());
        whitePieces.add(createWhiteKnight());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhiteKing());
        int sizeOfWhite = whitePieces.size();
        List<Piece> whiteTestPieces = game.getSortedWhitePieces(false);
        for (int i = 0; i < sizeOfWhite; i++) {
            assertEquals(whitePieces.get(i), whiteTestPieces.get(i));
        }
        whiteTestPieces = game.getSortedWhitePieces(true);
        for (int i = 0; i < sizeOfWhite; i++) {
            assertEquals(whitePieces.get(sizeOfWhite - i - 1), whiteTestPieces.get(i));
        }
    }

}