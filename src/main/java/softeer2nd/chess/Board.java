package softeer2nd.chess;

import softeer2nd.chess.exceptions.InvalidMoveException;
import softeer2nd.chess.exceptions.InvalidPositionException;
import softeer2nd.chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();

    public List<Rank> getRanks() {
        return ranks;
    }

    public void initBoard(String boardString) {
        ranks.clear();
        for (String rankString : boardString.split(NEWLINE)) {
            ranks.add(new Rank(rankString));
        }
    }

    private void place(Position position, Piece piece) {
        findRank(position).updatePiece(position, piece);
    }

    public void move(String from, String to) throws InvalidPositionException, InvalidMoveException {
        move(new Position(from), new Position(to));
    }

    private void move(Position from, Position to) throws InvalidMoveException {
        Piece piece = findPiece(from);
        if (findPiece(from).getColor() == findPiece(to).getColor()) {
            throw new InvalidMoveException("같은 편 위치로 이동할 수 없습니다.");
        }
        if (piece.verifyMovePosition(this, from, to)) {
            place(to, piece);
            place(from, createBlank());
        } else {
            throw new InvalidMoveException("해당 위치로 이동할 수 없습니다.");
        }
    }

    public int pieceCount(Piece piece) {
        int count = 0;
        for (Rank rank : ranks) {
            count += rank.pieceCount(piece);
        }
        return count;
    }

    private Rank findRank(Position position) {
        return ranks.get(position.getYDegree());
    }

    private Piece findPiece(Position position) {
        return findRank(position).findPiece(position);
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

    public String getRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            sb.append(rank.getRepresentation()).append(NEWLINE);
        }
        return sb.toString();
    }
}
