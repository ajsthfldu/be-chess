package softeer2nd.chess;

import static softeer2nd.utils.StringUtils.appendNewLine;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void initialize() {
        String blankRank = appendNewLine("........");
        String boardString =
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr");
        board.initBoard(boardString);
    }

    public void move(String sourcePosition, String targetPosition) {
        board.move(sourcePosition, targetPosition);
    }
}
