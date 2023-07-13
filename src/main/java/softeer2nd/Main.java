package softeer2nd;

import softeer2nd.chess.Board;
import softeer2nd.chess.Game;
import softeer2nd.chess.TerminalView;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        TerminalView view = new TerminalView();
        Game game = new Game(board, view);
        game.start();
    }
}