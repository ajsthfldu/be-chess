package softeer2nd.chess.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exceptions.InvalidPositionException;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean verifyMovePosition(Board board, Position sourcePosition, Position targetPosition) {
        List<Direction> directions = Direction.everyDirection();
        for (Direction direction : directions) {
            if (verifyDirection(board, direction, sourcePosition, targetPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyDirection(Board board, Direction direction, Position position, Position targetPosition) {
        try {
            Position nPosition = position.moved(direction);
            if (nPosition.equals(targetPosition)) {
                return true;
            }
            if (!board.isBlank(nPosition)) {
                return false;
            }
            return verifyDirection(board, direction, nPosition, targetPosition);
        } catch (InvalidPositionException e) {
            return false;
        }
    }
}
