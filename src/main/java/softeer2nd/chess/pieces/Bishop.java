package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    @Override
    public boolean verifyMovePosition(ChessGame chessGame, Position sourcePosition, Position targetPosition) {
        return false;
    }
}
