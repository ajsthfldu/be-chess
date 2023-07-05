package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.Piece.createWhiteBishop;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    List<Rank> ranks = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            ranks.add(new Rank());
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    ranks.get(i).pieces.add(createBlackPawn());
                } else if (i == 6) {
                    ranks.get(i).pieces.add(createWhitePawn());
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        ranks.get(i).pieces.add(createBlackRook());
                    } else if (j == 1 || j == 6) {
                        ranks.get(i).pieces.add(createBlackKnight());
                    } else if (j == 2 || j == 5) {
                        ranks.get(i).pieces.add(createBlackBishop());
                    } else if (j == 3) {
                        ranks.get(i).pieces.add(createBlackQueen());
                    } else {
                        ranks.get(i).pieces.add(createBlackKing());
                    }
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        ranks.get(i).pieces.add(createWhiteRook());
                    } else if (j == 1 || j == 6) {
                        ranks.get(i).pieces.add(createWhiteKnight());
                    } else if (j == 2 || j == 5) {
                        ranks.get(i).pieces.add(createWhiteBishop());
                    } else if (j == 3) {
                        ranks.get(i).pieces.add(createWhiteQueen());
                    } else {
                        ranks.get(i).pieces.add(createWhiteKing());
                    }
                } else {
                    ranks.get(i).pieces.add(createBlank());
                }
            }
        }
    }

    public String showBoard() {
        return getResult();
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            for (Piece piece : rank.pieces) {
                if (piece.getColor() == Color.WHITE) {
                    sb.append(piece.getType().getWhiteRepresentation());
                } else if (piece.getColor() == Color.BLACK) {
                    sb.append(piece.getType().getBlackRepresentation());
                } else {
                    sb.append(piece.getType().getWhiteRepresentation());
                }

            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public int pieceCount() {
        return 64 - pieceCount(Color.NOCOLOR, Type.NO_PIECE);
    }

    public int pieceCount(Color color, Type type) {
        int count = 0;
        for (Rank rank : ranks) {
            for (Piece piece : rank.pieces) {
                if (piece.getColor() == color && piece.getType() == type) {
                    ++count;
                }
            }
        }
        return count;
    }

    public Piece findPiece(String s) {
        int x = s.charAt(0) - 'a';
        int y = 8 - (s.charAt(1) - '0');
        return ranks.get(y).pieces.get(x);
    }
}

class Rank {
    List<Piece> pieces = new ArrayList<>();
}
