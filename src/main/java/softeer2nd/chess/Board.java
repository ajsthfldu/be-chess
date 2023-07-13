package softeer2nd.chess;

import softeer2nd.chess.exceptions.InvalidMoveException;
import softeer2nd.chess.exceptions.InvalidPositionException;
import softeer2nd.chess.exceptions.InvalidTurnException;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.Color;
import static softeer2nd.chess.pieces.Piece.Type;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    private boolean turnFlag = true;

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

    public void move(String from, String to) throws InvalidPositionException, InvalidMoveException, InvalidTurnException {
        move(new Position(from), new Position(to));
    }

    private void move(Position from, Position to) throws InvalidMoveException, InvalidTurnException {
        Piece piece = findPiece(from);
        if (!verifyTurn(piece)) {
            throw new InvalidTurnException("차례가 되지 않았습니다.");
        }
        if (from.equals(to)) {
            throw new InvalidMoveException("제 자리이동은 할 수 없습니다.");
        }
        if (piece.isSameColor(findPiece(to))) {
            throw new InvalidMoveException("같은 편 위치로 이동할 수 없습니다.");
        }
        if (verifyMove(piece, from, to)) {
            place(to, piece);
            place(from, createBlank());
            turnFlag = !turnFlag;
        } else {
            throw new InvalidMoveException("해당 위치로 이동할 수 없습니다.");
        }
    }

    private boolean verifyTurn(Piece piece) {
        return isWhiteTurn() == piece.isWhite();
    }

    private boolean isWhiteTurn() {
        return turnFlag;
    }

    private boolean verifyMove(Piece piece, Position from, Position to) {
        if (piece.isShortMove()) {
            return verifyShortMove(piece.getDirections(), from, to);
        }
        return verifyStraightMove(piece.getDirections(), from, to);
    }

    private boolean verifyShortMove(List<Direction> directions, Position from, Position to) {
        for (Direction direction : directions) {
            try {
                Position nPosition = from.moved(direction);
                if (nPosition.equals(to)) {
                    return true;
                }
            } catch (InvalidPositionException e) {
                return false;
            }
        }
        return false;
    }

    private boolean verifyStraightMove(List<Direction> directions, Position from, Position to) {
        for (Direction direction : directions) {
            if (verifyDirection(direction, from, to)) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyDirection(Direction direction, Position from, Position to) {
        try {
            Position nPosition = from.moved(direction);
            if (nPosition.equals(to)) {
                return true;
            }
            if (!isBlank(nPosition)) {
                return false;
            }
            return verifyDirection(direction, nPosition, to);
        } catch (InvalidPositionException e) {
            return false;
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
