package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;

public class Knight extends Piece {
    Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public List<Direction> getDirections() {
        return Direction.knightDirection();
    }

    @Override
    public boolean isShortMove() {
        return true;
    }
}
