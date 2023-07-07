package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

public class Pawn extends Piece {
    Pawn(Color color) {
        super(color, Type.PAWN);
    }

    @Override
    public boolean verifyMovePosition(ChessGame chessGame, Position sourcePosition, Position targetPosition) {
        return false;
    }
}
