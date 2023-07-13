package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.diagonalDirection();
    }

    @Override
    public boolean isShortMove() {
        return false;
    }
}
