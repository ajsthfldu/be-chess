package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class ChessGameTest {
    ChessGame game;

    @BeforeEach
    public void setup() {
        game = new ChessGame(new Board());
    }

    @Test
    @DisplayName("보드는 체스규칙에 따라 초기화해야 한다")
    public void create() throws Exception {
        game.initialize();
        assertEquals(32, game.getBoard().pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                new ChessView(game.getBoard()).showBoard());
    }

}