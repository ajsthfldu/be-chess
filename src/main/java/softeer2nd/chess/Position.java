package softeer2nd.chess;

import softeer2nd.chess.exceptions.InvalidPositionException;

import java.util.Objects;


public class Position {
    private final int xDegree;
    private final int yDegree;

    public static Position of(String position) throws InvalidPositionException {
        if (position.length() != 2) {
            throw new InvalidPositionException("유효한 위치 입력이 아닙니다.");
        }
        return new Position(position.charAt(0) - 'a', 8 - (position.charAt(1) - '0'));
    }

    public Position(int xDegree, int yDegree) throws InvalidPositionException {
        if (xDegree > 7 || xDegree < 0 || yDegree > 7 || yDegree < 0) {
            throw new InvalidPositionException("유효한 위치가 아닙니다.");
        }
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public int getXDegree() {
        return xDegree;
    }

    public int getYDegree() {
        return yDegree;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Position position = (Position) obj;
            return this.xDegree == position.xDegree && this.yDegree == position.yDegree;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(xDegree, yDegree);
    }

    public Position moved(Direction direction) throws InvalidPositionException {
        return new Position(xDegree + direction.getXDegree(), yDegree + direction.getYDegree());
    }
}
