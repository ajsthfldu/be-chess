package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

public class Knight extends Piece {
    Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    @Override
    public boolean verifyMovePosition(ChessGame chessGame, Position sourcePosition, Position targetPosition) {
        return false;
    }
}
