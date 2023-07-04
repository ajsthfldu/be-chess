package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;


import static softeer2nd.chess.pieces.Piece.*;

public class Board {

    Piece[][] piece2D = new Piece[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    piece2D[i][j] = new Piece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
                } else if (i == 6) {
                    piece2D[i][j] = new Piece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
                } else {
                    piece2D[i][j] = new Piece(EMPTY_COLOR, EMPTY_REPRESENTATION);
                }
            }
        }
    }

    public String getWhitePawnsResult() {
        return getResultByColors(new String[]{WHITE_COLOR}, false);
    }

    public String getBlackPawnsResult() {
        return getResultByColors(new String[]{BLACK_COLOR}, false);
    }

    public String print() {
        return getResultByColors(new String[]{EMPTY_COLOR, WHITE_COLOR, BLACK_COLOR}, true);
    }

    private String getResultByColors(String[] colors, boolean newLine) {
        StringBuilder sb = new StringBuilder();
        for (Piece[] pieces : piece2D) {
            for (Piece piece : pieces) {
                for (String color : colors) {
                    if (color.equals(piece.getColor())) {
                        sb.append(piece.getRepresentation());
                    }
                }
            }
            if (newLine) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
