package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.everyDirection();
    }

    @Override
    public boolean isShortMove() {
        return false;
    }
}
