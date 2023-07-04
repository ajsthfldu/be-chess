package softeer2nd.chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Pawn.BLACK_COLOR;
import static softeer2nd.chess.pieces.Pawn.WHITE_COLOR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

public class BoardTest {
    Board board;

    @BeforeEach
    public void createBoard() {
        board = new Board();
    }
    @Test
    @DisplayName("폰이 추가되면 보드 사이즈가 증가해야 한다")
    public void create() throws Exception {
        addPawnWithColor(WHITE_COLOR, 1);
        addPawnWithColor(BLACK_COLOR, 2);
    }

    public void addPawnWithColor (String color, int size) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(size - 1));
    }
}
