package softeer2nd;

import softeer2nd.chess.Board;
import softeer2nd.chess.Game;
import softeer2nd.chess.TerminalView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        TerminalView view = new TerminalView(board, game);
        view.init();
    }
}