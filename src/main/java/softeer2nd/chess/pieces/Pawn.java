package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

public class Pawn extends Piece {
    Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean verifyMovePosition(ChessGame game, Position sourcePosition, Position targetPosition) {
        List<Direction> directions;
        if (this.getColor() == Color.WHITE) {
            directions = Direction.whitePawnDirection();
        } else {
            directions = Direction.blackPawnDirection();
        }
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
