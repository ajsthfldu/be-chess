package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;

import java.util.List;
import java.util.Objects;

abstract public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        ROOK('r', 5.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);
        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultScore) {
            this.representation = representation;
            this.defaultPoint = defaultScore;
        }

        public char getWhiteRepresentation() {
            return representation;
        }
        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    private final Color color;
    private final Type type;
    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public boolean isSameColor(Piece piece) {
        return isSameColor(piece.color);
    }

    public char getRepresentation() {
        if (isWhite()) {
            return type.getWhiteRepresentation();
        } else {
            return type.getBlackRepresentation();
        }
    }

    abstract public List<Direction> getDirections();

    abstract public boolean isShortMove();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Piece piece = (Piece) obj;
            return this.color == piece.color && this.type == piece.type;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public String toString() {
        return color.toString() + "_" + type.toString();
    }
}
