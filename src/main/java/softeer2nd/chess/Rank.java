package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Piece.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.chess.pieces.PieceFactory.*;

class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public Rank(String rankStr) {
        for (char r : rankStr.toCharArray()) {
            switch (r) {
                case '.':
                    pieces.add(createBlank());
                    break;
                case 'p':
                    pieces.add(createWhitePawn());
                    break;
                case 'n':
                    pieces.add(createWhiteKnight());
                    break;
                case 'b':
                    pieces.add(createWhiteBishop());
                    break;
                case 'r':
                    pieces.add(createWhiteRook());
                    break;
                case 'q':
                    pieces.add(createWhiteQueen());
                    break;
                case 'k':
                    pieces.add(createWhiteKing());
                    break;
                case 'P':
                    pieces.add(createBlackPawn());
                    break;
                case 'N':
                    pieces.add(createBlackKnight());
                    break;
                case 'B':
                    pieces.add(createBlackBishop());
                    break;
                case 'R':
                    pieces.add(createBlackRook());
                    break;
                case 'Q':
                    pieces.add(createBlackQueen());
                    break;
                case 'K':
                    pieces.add(createBlackKing());
                    break;
            }
        }
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public List<Piece> getPieces(Color color) {
        return pieces.stream()
                .filter(piece -> piece.isSameColor(color))
                .collect(Collectors.toList());
    }

    public Piece findPiece(Position position) {
        return pieces.get(position.getXDegree());
    }

    public void updatePiece(Position position, Piece piece) {
        pieces.set(position.getXDegree(), piece);
    }

    public int pieceCount(Piece fpiece) {
        return (int) pieces.stream()
                .filter(piece -> piece.equals(fpiece))
                .count();
    }

    public String getRepresentation() {
        return pieces.stream().map(Piece::getRepresentation).map(String::valueOf).collect(Collectors.joining());
    }

    public double getPoint(Color color) {
        double point = 0;
        for (Piece piece : pieces) {
            if (piece.isSameColor(color)) {
                point += piece.getType().getDefaultPoint();
            }
        }
        return point;
    }
}
