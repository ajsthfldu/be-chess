package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    List<Rank> ranks = new ArrayList<>();

    Piece[][] piece2D = new Piece[8][8];


    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    piece2D[i][j] = createBlackPawn();
                } else if (i == 6) {
                    piece2D[i][j] = createWhitePawn();
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        piece2D[i][j] = createBlackRook();
                    } else if (j == 1 || j == 6) {
                        piece2D[i][j] = createBlackKnight();
                    } else if (j == 2 || j == 5) {
                        piece2D[i][j] = createBlackBishop();
                    } else if (j == 3) {
                        piece2D[i][j] = createBlackQueen();
                    } else {
                        piece2D[i][j] = createBlackKing();
                    }
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        piece2D[i][j] = createWhiteRook();
                    } else if (j == 1 || j == 6) {
                        piece2D[i][j] = createWhiteKnight();
                    } else if (j == 2 || j == 5) {
                        piece2D[i][j] = createWhiteBishop();
                    } else if (j == 3) {
                        piece2D[i][j] = createWhiteQueen();
                    } else {
                        piece2D[i][j] = createWhiteKing();
                    }
                } else {
                    piece2D[i][j] = createBlank();
                }
            }
        }
    }

    public String showBoard() {
        return getResult();
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (Piece[] pieces : piece2D) {
            for (Piece piece : pieces) {
                if (piece.getColor() == Color.WHITE) {
                    sb.append(piece.getType().getWhiteRepresentation());
                } else if (piece.getColor() == Color.BLACK) {
                    sb.append(piece.getType().getBlackRepresentation());
                } else {
                    sb.append(piece.getType().getWhiteRepresentation());
                }

            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public int pieceCount() {
        int count = 0;
        for (Piece[] pieces : piece2D) {
            for (Piece piece : pieces) {
                if (Type.NO_PIECE == piece.getType()) {
                    ++count;
                }
            }
        }
        return count;
    }
}

class Rank {
    List<Piece> pieces = new ArrayList<>();
}
