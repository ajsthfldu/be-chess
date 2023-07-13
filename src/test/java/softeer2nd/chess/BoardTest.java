package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exceptions.InvalidMoveException;
import softeer2nd.chess.exceptions.InvalidPositionException;
import softeer2nd.chess.exceptions.InvalidTurnException;

import java.util.List;

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
    void initialize() {
        board.initBoard(boardString);
        List<Rank> ranks = board.getRanks();
        assertEquals(boardString, board.getRepresentation());
    }

    @Test
    @DisplayName("기물을 움직일 수 있어야 한다.")
    void movePieces() throws InvalidPositionException, InvalidMoveException, InvalidTurnException {
        board.initBoard(boardString);
        List<Rank> ranks = board.getRanks();
        board.move("a2", "a3");
        String boardRepresentation = appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("........") +
                appendNewLine("p.......") +
                appendNewLine(".ppppppp") +
                appendNewLine("rnbqkbnr");
        assertEquals(board.getRepresentation(), boardRepresentation);
    }

    @Test
    @DisplayName("색상별 점수를 계산할 수 있어야 한다.")
    void calculatePoint() {
        board.initBoard(boardString);
        assertEquals(38.0, board.calculateWhitePoint());
        assertEquals(38.0, board.calculateBlackPoint());
    }
}