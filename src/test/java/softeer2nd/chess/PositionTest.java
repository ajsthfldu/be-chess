package softeer2nd.chess;

import org.junit.jupiter.api.Test;
import softeer2nd.chess.exceptions.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void create_fromInt() {
        assertDoesNotThrow(() -> new Position(0, 0));
        assertDoesNotThrow(() -> new Position(1, 1));
        assertDoesNotThrow(() -> new Position(2, 2));
        assertDoesNotThrow(() -> new Position(3, 5));
        assertDoesNotThrow(() -> new Position(7, 7));

        assertThrows(InvalidPositionException.class, () -> new Position(-1, 1));
        assertThrows(InvalidPositionException.class, () -> new Position(8, 8));
        assertThrows(InvalidPositionException.class, () -> new Position(0, 8));
        assertThrows(InvalidPositionException.class, () -> new Position(0, -1));
        assertThrows(InvalidPositionException.class, () -> new Position(12, 16));
    }

    @Test
    void create_fromString() {
        assertDoesNotThrow(() -> Position.of("a1"));
        assertDoesNotThrow(() -> Position.of("a8"));
        assertDoesNotThrow(() -> Position.of("h1"));
        assertDoesNotThrow(() -> Position.of("h8"));
        assertDoesNotThrow(() -> Position.of("e6"));

        assertThrows(InvalidPositionException.class, () -> Position.of("12"));
        assertThrows(InvalidPositionException.class, () -> Position.of("1d2"));
        assertThrows(InvalidPositionException.class, () -> Position.of("a12"));
        assertThrows(InvalidPositionException.class, () -> Position.of("i1"));
        assertThrows(InvalidPositionException.class, () -> Position.of("A2"));
    }
}