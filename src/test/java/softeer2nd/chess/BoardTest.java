package softeer2nd.chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;

public class BoardTest {
    Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("보드는 체스규칙에 따라 초기화해야 한다")
    public void create() throws Exception {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Test
    void pieceCount() {
        board.initialize();
        assertEquals(32, board.pieceCount(Color.NOCOLOR, Type.NO_PIECE));

        assertEquals(8, board.pieceCount(Color.WHITE, Type.PAWN));
        assertEquals(2, board.pieceCount(Color.WHITE, Type.KNIGHT));
        assertEquals(2, board.pieceCount(Color.WHITE, Type.ROOK));
        assertEquals(2, board.pieceCount(Color.WHITE, Type.BISHOP));
        assertEquals(1, board.pieceCount(Color.WHITE, Type.QUEEN));
        assertEquals(1, board.pieceCount(Color.WHITE, Type.KING));

        assertEquals(8, board.pieceCount(Color.BLACK, Type.PAWN));
        assertEquals(2, board.pieceCount(Color.BLACK, Type.KNIGHT));
        assertEquals(2, board.pieceCount(Color.BLACK, Type.ROOK));
        assertEquals(2, board.pieceCount(Color.BLACK, Type.BISHOP));
        assertEquals(1, board.pieceCount(Color.BLACK, Type.QUEEN));
        assertEquals(1, board.pieceCount(Color.BLACK, Type.KING));
    }

    @Test
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(createBlackRook(), board.findPiece("a8"));
        assertEquals(createBlackRook(), board.findPiece("h8"));
        assertEquals(createWhiteRook(), board.findPiece("a1"));
        assertEquals(createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

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

        assertEquals(20.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(19.5, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    public void getSortedPieces() {
        board.initializeEmpty();

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
        List<Piece> blackTestPieces = board.getBlackPieces(false);
        for (int i = 0; i < sizeOfBlack; i++) {
            assertEquals(blackPieces.get(i), blackTestPieces.get(i));
        }
        blackTestPieces = board.getBlackPieces(true);
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
        List<Piece> whiteTestPieces = board.getWhitePieces(false);
        for (int i = 0; i < sizeOfWhite; i++) {
            assertEquals(whitePieces.get(i), whiteTestPieces.get(i));
        }
        whiteTestPieces = board.getWhitePieces(true);
        for (int i = 0; i < sizeOfWhite; i++) {
            assertEquals(whitePieces.get(sizeOfWhite - i - 1), whiteTestPieces.get(i));
        }
    }
}
