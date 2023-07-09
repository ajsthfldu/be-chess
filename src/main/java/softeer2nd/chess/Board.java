package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.Rank;


import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public List<Rank> getRanks() {
        return ranks;
    }

    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            ranks.add(new Rank());
        }
    }

    public void initBoard(String boardString) {
        for (String rankString : boardString.split(NEWLINE)) {
            ranks.add(new Rank(rankString));
        }
    }

    public void clear() {
        ranks.clear();
        whitePieces.clear();
        blackPieces.clear();
    }

    public void move(Position position, Piece piece) {
        Piece removedPiece = findPiece(position);
        findRank(position).updatePiece(position, piece);
        if (piece.isBlack()) {
            blackPieces.add(piece);
            blackPieces.remove(removedPiece);
        } else {
            whitePieces.add(piece);
            whitePieces.remove(removedPiece);
        }
    }

    public int pieceCount(Piece piece) {
        int count = 0;
        for (Rank rank : ranks) {
            count += rank.pieceCount(piece);
        }
        return count;
    }

    public Rank findRank(Position position) {
        return ranks.get(position.getYDegree());
    }

    public Piece findPiece(Position position) {
        return findRank(position).findPiece(position);
    }

    public boolean isBlank(Position nPosition) {
        return findPiece(nPosition).equals(createBlank());
    }

    public List<Piece> getSortedBlackPieces(boolean reverse) {
        if (!reverse) {
            blackPieces.sort((o1, o2) -> (int) (o2.getType().getDefaultPoint() - o1.getType().getDefaultPoint()));
        } else {
            blackPieces.sort((o1, o2) -> (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint()));
        }
        return blackPieces;
    }


    public List<Piece> getSortedWhitePieces(boolean reverse) {
        if (!reverse) {
            whitePieces.sort((o1, o2) -> (int) (o2.getType().getDefaultPoint() - o1.getType().getDefaultPoint()));
        } else {
            whitePieces.sort((o1, o2) -> (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint()));
        }
        return whitePieces;
    }

    public double calculatePoint(Color color) {
        double score = 0;
        List<Piece> pieces;
        if (color == Color.WHITE) {
            pieces = whitePieces;
        } else {
            pieces = blackPieces;
        }
        for (Piece piece : pieces) {
            score += piece.getType().getDefaultPoint();
        }
        for (int i = 0; i < 8; i++) {
            int pawnCount = 0;
            for (int j = 0; j < 8; j++) {
                Piece piece = findPiece(new Position(i, j));
                if (piece.getColor() == color && piece.getType() == Type.PAWN) {
                    ++pawnCount;
                }
            }
            if (pawnCount > 1) {
                score -= 0.5 * pawnCount;
            }

        }
        return score;
    }
}

