package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Pawn.BLACK_COLOR;
import static softeer2nd.chess.pieces.Pawn.WHITE_COLOR;

public class Board {

    List<List<Pawn>> pawnList;
//    public void add(Pawn pawn) {
//        pawnList.add(pawn);
//    }
//
//    public int size() {
//        return pawnList.size();
//    }
//
//    public Pawn findPawn(int i) {
//        return pawnList.get(i);
//    }

    public void initialize() {
        pawnList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<Pawn> nullList = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                nullList.add(null);
            }
            pawnList.add(nullList);
        }
        for (int i = 0; i < 8; i++) {
            pawnList.get(1).set(i, new Pawn(BLACK_COLOR));
        }
        for (int i = 0; i < 8; i++) {
            pawnList.get(6).set(i, new Pawn(WHITE_COLOR));
        }
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (List<Pawn> pawns : pawnList) {
            for (Pawn pawn : pawns) {
                if (pawn != null && pawn.getColor().equals(WHITE_COLOR)) {
                    sb.append(pawn.getRepresentation());
                }
            }
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (List<Pawn> pawns : pawnList) {
            for (Pawn pawn : pawns) {
                if (pawn != null && pawn.getColor().equals(BLACK_COLOR)) {
                    sb.append(pawn.getRepresentation());
                }
            }
        }
        return sb.toString();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (List<Pawn> pawns : pawnList) {
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
