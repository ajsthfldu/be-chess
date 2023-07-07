package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

public class Blank extends Piece {
    public Blank() {
        super(Color.NOCOLOR, Type.NO_PIECE);
    }

    @Override
    public boolean verifyMovePosition(ChessGame chessGame, Position sourcePosition, Position targetPosition) {
        return true;
    }
}
