package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.PieceFactory.*;

class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public Rank() {
        for (int i = 0; i < 8; i++) {
            pieces.add(createBlank());
        }
    }

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

    public void updatePiece(int index, Piece piece) {
        pieces.set(index, piece);
    }

}
