package softeer2nd.chess.pieces;

public class PieceFactory {
    private static final Piece blank = new Blank();
    private static final Piece whitePawn = new Pawn(Piece.Color.WHITE);
    private static final Piece whiteKnight = new Knight(Piece.Color.WHITE);
    private static final Piece whiteBishop = new Bishop(Piece.Color.WHITE);
    private static final Piece whiteRook = new Rook(Piece.Color.WHITE);
    private static final Piece whiteQueen = new Queen(Piece.Color.WHITE);
    private static final Piece whiteKing = new King(Piece.Color.WHITE);
    private static final Piece blackPawn = new Pawn(Piece.Color.BLACK);
    private static final Piece blackKnight = new Knight(Piece.Color.BLACK);
    private static final Piece blackBishop = new Bishop(Piece.Color.BLACK);
    private static final Piece blackRook = new Rook(Piece.Color.BLACK);
    private static final Piece blackQueen = new Queen(Piece.Color.BLACK);
    private static final Piece blackKing = new King(Piece.Color.BLACK);

    public static Piece createBlank() {
        return blank;
    }

    public static Piece createWhitePawn() {
        return whitePawn;
    }
    public static Piece createBlackPawn() {
        return blackPawn;
    }

    public static Piece createWhiteKnight() {
        return whiteKnight;
    }
    public static Piece createBlackKnight() {
        return blackKnight;
    }

    public static Piece createWhiteBishop() {
        return whiteBishop;
    }
    public static Piece createBlackBishop() {
        return blackBishop;
    }

    public static Piece createWhiteRook() {
        return whiteRook;
    }
    public static Piece createBlackRook() {
        return blackRook;
    }

    public static Piece createWhiteQueen() {
        return whiteQueen;
    }
    public static Piece createBlackQueen() {
        return blackQueen;
    }

    public static Piece createWhiteKing() {
        return whiteKing;
    }
    public static Piece createBlackKing() {
        return blackKing;
    }
}
