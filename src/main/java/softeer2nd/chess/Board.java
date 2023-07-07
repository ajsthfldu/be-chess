package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.Rank;


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

    public void clear() {
        ranks.clear();
        whitePieces.clear();
        blackPieces.clear();
    }
}

