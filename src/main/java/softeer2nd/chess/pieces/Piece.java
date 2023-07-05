package softeer2nd.chess.pieces;

import java.util.Objects;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }


    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    public static final String EMPTY_COLOR = "empty";

    public static final char EMPTY_REPRESENTATION = '.';

    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';

    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';

    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';

    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';

    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';

    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';


    public static Piece createBlank() {
        return new Piece(EMPTY_COLOR, "empty", EMPTY_REPRESENTATION);
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, "pawn", WHITE_PAWN_REPRESENTATION);
    }
    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, "pawn", BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, "knight", WHITE_KNIGHT_REPRESENTATION);
    }
    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, "knight", BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE_COLOR, "rook", WHITE_ROOK_REPRESENTATION);
    }
    public static Piece createBlackRook() {
        return new Piece(BLACK_COLOR, "rook", BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE_COLOR, "bishop", WHITE_BISHOP_REPRESENTATION);
    }
    public static Piece createBlackBishop() {
        return new Piece(BLACK_COLOR, "bishop", BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE_COLOR, "queen", WHITE_QUEEN_REPRESENTATION);
    }
    public static Piece createBlackQueen() {
        return new Piece(BLACK_COLOR, "queen", BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE_COLOR, "king", WHITE_KING_REPRESENTATION);
    }
    public static Piece createBlackKing() {
        return new Piece(BLACK_COLOR, "king", BLACK_KING_REPRESENTATION);
    }

    private String color;
    private String name;
    private char representation;

    private Piece(String color, String name, char representation) {
        this.color = color;
        this.name = name;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isWhite() {
        return WHITE_COLOR.equals(color);
    }

    public boolean isBlack() {
        return BLACK_COLOR.equals(color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Piece piece = (Piece) obj;
            return this.name.equals(piece.name) &&
                    this.color.equals(piece.color) &&
                    this.representation == piece.representation;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name, representation);
    }

}
