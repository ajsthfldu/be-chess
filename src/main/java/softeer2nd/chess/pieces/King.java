package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

public class King extends Piece {
    public King(Color color) {
        super(color, Type.KING);
    }

    @Override
    public boolean verifyMovePosition(ChessGame game, Position sourcePosition, Position targetPosition) {
        List<Direction> directions = Direction.everyDirection();
        for (Direction direction : directions) {
            Position nPosition = sourcePosition.moved(direction);
            if (nPosition == targetPosition) {
                return true;
            }
        }
        return false;
    }
}
