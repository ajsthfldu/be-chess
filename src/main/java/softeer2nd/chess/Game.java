package softeer2nd.chess;

import softeer2nd.chess.exceptions.InvalidMoveException;
import softeer2nd.chess.exceptions.InvalidPositionException;
import softeer2nd.chess.exceptions.InvalidTurnException;

import static softeer2nd.utils.StringUtils.appendNewLine;

public class Game {
    private final Board board;
    private final TerminalView view;

    public Game(Board board, TerminalView view) {
        this.board = board;
        this.view = view;
    }

    public void start() {
        view.setGame(this);
        view.init();
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
        view.update();
    }

    public void move(String sourcePosition, String targetPosition) {
        try {
            board.move(sourcePosition, targetPosition);
            view.update();
        } catch (InvalidPositionException | InvalidMoveException | InvalidTurnException e) {
            view.print(e.getMessage());
        }
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
