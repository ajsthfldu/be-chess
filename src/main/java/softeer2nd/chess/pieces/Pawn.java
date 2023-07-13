package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;

public class Pawn extends Piece {
    Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public List<Direction> getDirections() {
        if (isWhite()) {
            return Direction.whitePawnDirection();
        }
        return Direction.blackPawnDirection();
    }

    @Override
    public boolean isShortMove() {
        return true;
    }
}
