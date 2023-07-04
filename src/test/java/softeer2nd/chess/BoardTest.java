package softeer2nd.chess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    Board board;

    @BeforeEach
    public void createBoard() {
        board = new Board();
    }

    @Test
    public void initialize() throws Exception {
        board.initialize();
        System.out.println(board.print());
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}
