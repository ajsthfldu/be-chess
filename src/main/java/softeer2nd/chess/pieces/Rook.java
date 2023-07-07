package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, Type.ROOK);
    }

    @Override
    public boolean verifyMovePosition(ChessGame chessGame, Position sourcePosition, Position targetPosition) {
        return false;
    }
}
