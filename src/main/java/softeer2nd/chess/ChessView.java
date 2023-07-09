package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import static softeer2nd.utils.StringUtils.NEWLINE;

public class ChessView {
    Board board;

    public ChessView(Board board) {
        this.board = board;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board.getRanks()) {
            for (Piece piece : rank.getPieces()) {
                if (piece.isWhite()) {
                    sb.append(piece.getType().getWhiteRepresentation());
                } else if (piece.isBlack()) {
                    sb.append(piece.getType().getBlackRepresentation());
                } else {
                    sb.append(piece.getType().getWhiteRepresentation());
                }
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
