package softeer2nd.chess.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

public class King extends Piece {
    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean verifyMovePosition(Board board, Position sourcePosition, Position targetPosition) {
        List<Direction> directions = Direction.everyDirection();
        for (Direction direction : directions) {
            try {
                Position nPosition = sourcePosition.moved(direction);
                if (nPosition.equals(targetPosition)) {
                    return true;
                }
            } catch (Exception ignored) {
            }
        }
        return false;
    }
}
