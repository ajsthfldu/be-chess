package softeer2nd.chess;

class Position {
    int x;
    int y;

    public Position(String position) {
        x = 8 - (position.charAt(1) - '0');
        y = position.charAt(0) - 'a';
    }
}
