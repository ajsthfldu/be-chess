package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.ArrayList;
import java.util.List;

public class Blank extends Piece {
    public Blank() {
        super(Color.NOCOLOR, Type.NO_PIECE);
    }

    @Override
    public List<Direction> getDirections() {
        return new ArrayList<>();
    }

    @Override
    public boolean isShortMove() {
        return true;
    }
}
