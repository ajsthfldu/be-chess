package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();

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
        notifyObservers();
    }

    private void clear() {
        ranks.clear();
    }

    public void move(Position position, Piece piece) {
        findRank(position).updatePiece(position, piece);
    }

    public void move(String from, String to) {
        move(new Position(from), new Position(to));
    }

    public void move(Position from, Position to) {
        Piece piece = findPiece(from);
        if (findPiece(from).getColor() == findPiece(to).getColor()) {
            notifyObservers();
            return;
        }
        if (piece.verifyMovePosition(this, from, to)) {
            move(to, piece);
            move(from, createBlank());
        }
        notifyObservers();
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

    public double calculatePoint(Color color) {
        double score = 0;
        for (Rank rank : ranks) {
            score += rank.getPoint(color);
        }
        for (int i = 0; i < 8; i++) {
            int pawnCount = 0;
            for (int j = 0; j < 8; j++) {
                if (ranks.get(j).getPieces().get(i).getType() == Type.PAWN) {
                    ++pawnCount;
                }
            }
            score -= pawnCount * 0.5;
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

