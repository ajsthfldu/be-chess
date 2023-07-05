package softeer2nd.chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

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
        assertEquals(32, board.pieceCount(Piece.Color.NOCOLOR, Piece.Type.NO_PIECE));

        assertEquals(8, board.pieceCount(Piece.Color.WHITE, Piece.Type.PAWN));
        assertEquals(2, board.pieceCount(Piece.Color.WHITE, Piece.Type.KNIGHT));
        assertEquals(2, board.pieceCount(Piece.Color.WHITE, Piece.Type.ROOK));
        assertEquals(2, board.pieceCount(Piece.Color.WHITE, Piece.Type.BISHOP));
        assertEquals(1, board.pieceCount(Piece.Color.WHITE, Piece.Type.QUEEN));
        assertEquals(1, board.pieceCount(Piece.Color.WHITE, Piece.Type.KING));

        assertEquals(8, board.pieceCount(Piece.Color.BLACK, Piece.Type.PAWN));
        assertEquals(2, board.pieceCount(Piece.Color.BLACK, Piece.Type.KNIGHT));
        assertEquals(2, board.pieceCount(Piece.Color.BLACK, Piece.Type.ROOK));
        assertEquals(2, board.pieceCount(Piece.Color.BLACK, Piece.Type.BISHOP));
        assertEquals(1, board.pieceCount(Piece.Color.BLACK, Piece.Type.QUEEN));
        assertEquals(1, board.pieceCount(Piece.Color.BLACK, Piece.Type.KING));
    }

    @Test
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }
}
