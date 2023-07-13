package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.linearDirection();
    }

    @Override
    public boolean isShortMove() {
        return false;
    }
}
