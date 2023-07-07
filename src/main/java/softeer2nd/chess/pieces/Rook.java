package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, Type.ROOK);
    }
    @Override
    public boolean verifyMovePosition(ChessGame game, Position sourcePosition, Position targetPosition) {
        List<Direction> directions = Direction.linearDirection();
        for (Direction direction : directions) {
            try {
                if (verifyDirection(game, direction, sourcePosition, targetPosition)) {
                    return true;
                }
            } catch (Exception ignored) {
            }
        }
        return false;
    }

    public boolean verifyDirection(ChessGame game, Direction direction, Position position, Position targetPosition) {
        Position nPosition = position.moved(direction);
        if (nPosition.equals(targetPosition)) {
            return true;
        }
        if (!game.isBlank(nPosition)) {
            return false;
        }
        return verifyDirection(game, direction, nPosition, targetPosition);
    }
}
