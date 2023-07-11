package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertEquals(ranks.get(0).getRepresentation(), "RNBQKBNR");
        assertEquals(ranks.get(1).getRepresentation(), "PPPPPPPP");
        assertEquals(ranks.get(2).getRepresentation(), "........");
        assertEquals(ranks.get(3).getRepresentation(), "........");
        assertEquals(ranks.get(4).getRepresentation(), "........");
        assertEquals(ranks.get(5).getRepresentation(), "........");
        assertEquals(ranks.get(6).getRepresentation(), "pppppppp");
        assertEquals(ranks.get(7).getRepresentation(), "rnbqkbnr");
    }

    @Test
    @DisplayName("기물을 움직일 수 있어야 한다.")
    void movePieces() {
        board.initBoard(boardString);
        List<Rank> ranks = board.getRanks();
        board.move("a2", "a3");
        assertEquals(board.findPiece("a2"), createBlank());
        assertEquals(board.findPiece("a3"), createWhitePawn());
    }

    @Test
    @DisplayName("색상별 점수를 계산할 수 있어야 한다.")
    void calculatePoint() {
        fail();
        board.initBoard(boardString);
        assertEquals(board.calculateWhitePoint(), 38.0);
        assertEquals(board.calculateBlackPoint(), 38.0);
    }

    @Test
    @DisplayName("기물의 점수를 기준으로 정렬할 수 있어야 한다.")
    void sort() {
        fail();
    }
}