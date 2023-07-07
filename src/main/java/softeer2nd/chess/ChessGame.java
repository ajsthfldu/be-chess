package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class ChessGame {
    private final Board board;

    public ChessGame() {
        board = new Board();
    }

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
        board.clear();
        board.initBoard(boardString);
    }

    public void initializeEmpty() {
        board.clear();
        board.initBoard();
    }


    public int pieceCount() {
        return 64 - pieceCount(Color.NOCOLOR, Type.NO_PIECE);
    }

    public int pieceCount(Color color, Type type) {
        int count = 0;
        for (Rank rank : board.getRanks()) {
            for (Piece piece : rank.getPieces()) {
                if (piece.getColor() == color && piece.getType() == type) {
                    ++count;
                }
            }
        }
        return count;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        return board.getRanks().get(pos.getYDegree()).getPieces().get(pos.getXDegree());
    }

    public Piece findPiece(Position position) {
        return board.getRanks().get(position.getYDegree()).getPieces().get(position.getXDegree());
    }

    public void move(String position, Piece piece) {
        Position pos = new Position(position);
        board.move(pos, piece);
    }

    public void move(String sourcePosition, String targetPosition) {
        move(new Position(sourcePosition), new Position(targetPosition));
    }

    public void move(Position sourcePosition, Position targetPosition) {
        Piece piece = findPiece(sourcePosition);

        if (findPiece(targetPosition).getColor() == findPiece(sourcePosition).getColor()) {
            System.out.println("같은 편 위치로 이동할 수 없습니다.");
        } else if (piece.verifyMovePosition(this, sourcePosition, targetPosition)) {
            board.move(targetPosition, piece);
            board.move(sourcePosition, createBlank());
        } else {
            System.out.println("해당 위치로 이동할 수 없습니다.");
        }
    }

    public double calculatePoint(Color color) {
        double score = 0;
        for (Rank rank : board.getRanks()) {
            for (Piece piece : rank.getPieces()) {
                if (piece.getColor() == color) {
                    score += piece.getType().getDefaultPoint();
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            int pawnCount = 0;
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getRanks().get(j).getPieces().get(i);
                if (piece.getColor() == color && piece.getType() == Type.PAWN) {
                    ++pawnCount;
                }
            }
            if (pawnCount > 1) {
                score -= 0.5 * pawnCount;
            }

        }
        return score;
    }


    public List<Piece> getSortedBlackPieces(boolean reverse) {
        if (!reverse) {
            this.getBoard().getBlackPieces().sort((o1, o2) -> (int) (o2.getType().getDefaultPoint() - o1.getType().getDefaultPoint()));
        } else {
            this.getBoard().getBlackPieces().sort((o1, o2) -> (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint()));
        }
        return this.getBoard().getBlackPieces();
    }

    public List<Piece> getSortedWhitePieces(boolean reverse) {
        if (!reverse) {
            this.getBoard().getWhitePieces().sort((o1, o2) -> (int) (o2.getType().getDefaultPoint() - o1.getType().getDefaultPoint()));
        } else {
            this.getBoard().getWhitePieces().sort((o1, o2) -> (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint()));
        }
        return this.getBoard().getWhitePieces();
    }

    public boolean isBlank(Position nPosition) {
        return findPiece(nPosition).equals(createBlank());
    }
}
