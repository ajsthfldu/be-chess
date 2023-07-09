package softeer2nd.chess.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

public class Knight extends Piece {
    Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean verifyMovePosition(Board board, Position sourcePosition, Position targetPosition) {
        List<Direction> directions = Direction.knightDirection();
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
