package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.List;

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
                    pawn2d[i][j] = null;
                }
            }
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn[] pawns : pawn2d) {
            for (Pawn pawn : pawns) {
                if (pawn != null && WHITE_COLOR.equals(pawn.getColor())) {
                    sb.append(pawn.getRepresentation());
                }
            }
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn[] pawns : pawn2d) {
            for (Pawn pawn : pawns) {
                if (pawn != null && BLACK_COLOR.equals(pawn.getColor())) {
                    sb.append(pawn.getRepresentation());
                }
            }
        }
        return sb.toString();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Pawn[] pawns : pawn2d) {
            for (Pawn pawn : pawns) {
                if (pawn == null) {
                    sb.append('.');
                } else if (WHITE_COLOR.equals(pawn.getColor())) {
                    sb.append(pawn.getRepresentation());
                } else {
                    sb.append(pawn.getRepresentation());
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
