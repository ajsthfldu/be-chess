package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;

public class King extends Piece {
    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }

    @Override
    public boolean isShortMove() {
        return true;
    }
}
