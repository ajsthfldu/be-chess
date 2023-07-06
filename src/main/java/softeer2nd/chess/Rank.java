package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public Rank() {
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
