package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import static softeer2nd.utils.StringUtils.NEWLINE;
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


    public String getSortedWhitePiecesRepresentation(boolean reverse) {
        return null;
    }

    public String getSortedBlackPiecesRepresentation(boolean reverse) {
        return null;
    }

    public String getBoardRepresentation() {
        return board.getRepresentation();
    }
}
