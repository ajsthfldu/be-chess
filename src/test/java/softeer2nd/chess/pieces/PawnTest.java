package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Pawn.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은 색 폰을 만들어야 한다")
    public void create() {
        verifyPawnColor(WHITE_COLOR);
        verifyPawnColor(BLACK_COLOR);
    }

    public void verifyPawnColor(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본생성자는 흰색 폰을 만들어야 한다")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(WHITE_COLOR, pawn.getColor());
    }
}
