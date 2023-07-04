package softeer2nd.chess.pieces;

public class Pawn {

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";

    private String color;

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn() {
        this(WHITE_COLOR);
    }

    public String getColor() {
        return color;
    }
}
