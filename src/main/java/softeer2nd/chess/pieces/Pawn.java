package softeer2nd.chess.pieces;

public class Pawn {

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private String color;
    private char representation;

    public Pawn(String color) {
        this.color = color;
        this.representation = color.equals(WHITE_COLOR) ? 'p' : 'P';
    }

    public Pawn() {
        this(WHITE_COLOR);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
