package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;


import static softeer2nd.chess.pieces.Pawn.*;

public class Board {

    Pawn[][] pawn2d = new Pawn[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    pawn2d[i][j] = new Pawn(BLACK_COLOR, BLACK_REPRESENTATION);
                } else if (i == 6) {
                    pawn2d[i][j] = new Pawn(WHITE_COLOR, WHITE_REPRESENTATION);
                } else {
                    pawn2d[i][j] = new Pawn(EMPTY_COLOR, EMPTY_REPRESENTATION);
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
        for (Pawn[] pawns : pawn2d) {
            for (Pawn pawn : pawns) {
                for (String color : colors) {
                    if (color.equals(pawn.getColor())) {
                        sb.append(pawn.getRepresentation());
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
