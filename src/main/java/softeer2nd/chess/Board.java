package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public List<Rank> getRanks() {
        return ranks;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public List<Piece> getSortedBlackPieces(boolean reverse) {
        if (!reverse) {
            blackPieces.sort((o1, o2) -> (int) (o2.getType().getDefaultPoint() - o1.getType().getDefaultPoint()));
        } else {
            blackPieces.sort((o1, o2) -> (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint()));
        }
        return blackPieces;
    }

    public List<Piece> getSortedWhitePieces(boolean reverse) {
        if (!reverse) {
            whitePieces.sort((o1, o2) -> (int) (o2.getType().getDefaultPoint() - o1.getType().getDefaultPoint()));
        } else {
            whitePieces.sort((o1, o2) -> (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint()));
        }
        return whitePieces;
    }
}

