package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {
    Board board;
    String blankRank = appendNewLine("........");
    String boardString =
            appendNewLine("RNBQKBNR") +
                    appendNewLine("PPPPPPPP") +
                    blankRank + blankRank + blankRank + blankRank +
                    appendNewLine("pppppppp") +
                    appendNewLine("rnbqkbnr");
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드를 기물이 없는 상태로 초기화 할 수 있어야 한다.")
    void initBoard() {
        board.initBoard();
        String blankRank = appendNewLine("........");
        String boardString = blankRank + blankRank + blankRank + blankRank +
                blankRank + blankRank + blankRank + blankRank + blankRank;
        assertEquals(boardString, new ChessView(board).showBoard());
    }

    @Test
    @DisplayName("보드를 주어진 문자열을 따라 초기화 할 수 있어야 한다.")
    void initBoardPiece() {
        board.initBoard(boardString);
        assertEquals(boardString, new ChessView(board).showBoard());
    }

    @Test
    @DisplayName("보드를 비울 수 있어야 한다.")
    void clear() {
        board.clear();
        assertEquals(0, board.getRanks().size());
        assertEquals(0, board.getSortedBlackPieces(true).size());
        assertEquals(0, board.getSortedWhitePieces(true).size());
    }

    @Test
    @DisplayName("기물을 원하는 위치에 놓을 수 있어야 한다.")
    void move() {

    }

    @Test
    @DisplayName("기물을 움직일 수 있어야 한다.")
    void movePieces() {

    }

    @Test
    @DisplayName("기물의 갯수를 셀 수 있어야 한다.")
    void pieceCount() {
        board.initBoard(boardString);
        assertEquals(32, board.pieceCount(createBlank()));
        assertEquals(8, board.pieceCount(createWhitePawn()));
        assertEquals(8, board.pieceCount(createBlackPawn()));
        assertEquals(2, board.pieceCount(createWhiteKnight()));
        assertEquals(2, board.pieceCount(createBlackKnight()));
        assertEquals(2, board.pieceCount(createWhiteBishop()));
        assertEquals(2, board.pieceCount(createBlackBishop()));
        assertEquals(2, board.pieceCount(createWhiteRook()));
        assertEquals(2, board.pieceCount(createBlackRook()));
        assertEquals(1, board.pieceCount(createWhiteQueen()));
        assertEquals(1, board.pieceCount(createBlackQueen()));
        assertEquals(1, board.pieceCount(createWhiteKing()));
        assertEquals(1, board.pieceCount(createBlackKing()));
    }

    @Test
    @DisplayName("위치를 통해 기물을 찾을 수 있어야 한다.")
    void findPiece() {
        board.initBoard(boardString);
        assertEquals(createWhitePawn(), board.findPiece(new Position("a2")));
        assertEquals(createBlackRook(), board.findPiece(new Position("a8")));
        assertEquals(createBlackRook(), board.findPiece(new Position("h8")));
        assertEquals(createWhiteRook(), board.findPiece(new Position("a1")));
        assertEquals(createWhiteRook(), board.findPiece(new Position("h1")));
    }

    @Test
    void getSortedBlackPieces() {

    }

    @Test
    void getSortedWhitePieces() {
    }

    @Test
    @DisplayName("색상별 점수를 계산할 수 있어야 한다.")
    void calculatePoint() {
        board.initBoard(boardString);

        board.move(new Position("b6"), createBlackPawn());
        board.move(new Position("e6"), createBlackQueen());
        board.move(new Position("a7"), createBlackPawn());
        board.move(new Position("c7"), createBlackPawn());
        board.move(new Position("d7"), createBlackBishop());
        board.move(new Position("b8"), createBlackKing());
        board.move(new Position("c8"), createBlackRook());

        board.move(new Position("f4"), createWhiteKnight());
        board.move(new Position("g4"), createWhiteQueen());
        board.move(new Position("f3"), createWhitePawn());
        board.move(new Position("h2"), createWhitePawn());
        board.move(new Position("f2"), createWhitePawn());
        board.move(new Position("g2"), createWhitePawn());
        board.move(new Position("e1"), createWhiteRook());
        board.move(new Position("f1"), createWhiteKing());

        assertEquals(20.0, board.calculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(19.5, board.calculatePoint(Piece.Color.WHITE), 0.01);
    }
}