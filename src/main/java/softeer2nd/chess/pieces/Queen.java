package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    @Override
    public boolean verifyMovePosition(ChessGame chessGame, Position sourcePosition, Position targetPosition) {
        List<Direction> directions = Direction.everyDirection();
        for (Direction direction : directions) {
            Position nPosition = sourcePosition.moved(direction);
            if (nPosition == targetPosition) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyDirection(Direction direction, Position position) {
        return false;
    }
}
