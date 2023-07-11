package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.Rank;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public void initBoard(String boardString) {
        clear();
        for (String rankString : boardString.split(NEWLINE)) {
            ranks.add(new Rank(rankString));
        }
        for (Rank rank : ranks) {
            whitePieces.addAll(rank.getPieces(Color.WHITE));
            blackPieces.addAll(rank.getPieces(Color.BLACK));
        }
    }

    private void clear() {
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

    public void move(String from, String to) {
        move(new Position(from), new Position(to));
    }

    public void move(Position from, Position to) {

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

    public Piece findPiece(String position) {
        return findPiece(new Position(position));
    }

    public boolean isBlank(Position nPosition) {
        return findPiece(nPosition).equals(createBlank());
    }

    public List<Piece> getSortedBlackPieces(boolean reverse) {
        if (!reverse) {
            blackPieces.sort(Comparator.comparingDouble(o -> -o.getType().getDefaultPoint()));
        } else {
            blackPieces.sort(Comparator.comparingDouble(o -> o.getType().getDefaultPoint()));
        }
        return blackPieces;
    }


    public List<Piece> getSortedWhitePieces(boolean reverse) {
        if (!reverse) {
            whitePieces.sort(Comparator.comparingDouble(o -> -o.getType().getDefaultPoint()));
        } else {
            whitePieces.sort(Comparator.comparingDouble(o -> o.getType().getDefaultPoint()));
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

    public double calculateWhitePoint() {
        return calculatePoint(Color.WHITE);
    }

    public double calculateBlackPoint() {
        return calculatePoint(Color.BLACK);
    }
}

