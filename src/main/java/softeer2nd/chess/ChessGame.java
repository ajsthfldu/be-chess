package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.pieces.PieceFactory.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class ChessGame {
    private final Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
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

    public void initializeEmpty() {
        board.initBoard();
    }

    public void move(String position, Piece piece) {
        board.move(new Position(position), piece);
    }

    public void move(String sourcePosition, String targetPosition) {
        board.move(new Position(sourcePosition), new Position(targetPosition));
    }
}
